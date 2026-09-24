package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import med.voll.api.dto.MedicoCreateDto;
import med.voll.api.dto.MedicoDetailsDto;
import med.voll.api.dto.MedicoReadDto;
import med.voll.api.dto.MedicoUpdateDto;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public ResponseEntity<Page<MedicoReadDto>> listarMedicos(
            @PageableDefault(size = 15, sort = { "numeroCrm" }, direction = Direction.DESC) Pageable paginacao) {
        var pagina = medicoRepository.findAllByAtivoTrue(paginacao).map(MedicoReadDto::new);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("{id}")
    public ResponseEntity<MedicoDetailsDto> exibirMedico(@PathVariable Long id) {
        var medico = medicoRepository.findById(id);
        var dto = new MedicoDetailsDto(medico.get());

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<MedicoDetailsDto> cadastrarMedico(@RequestBody @Valid MedicoCreateDto json,
            UriComponentsBuilder uriBuilder) {

        Medico medico = new Medico(json);
        medicoRepository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new MedicoDetailsDto(medico));
    }

    @PostMapping("batch")
    public ResponseEntity<String> cadastrarVariosMedicos(@RequestBody @Valid List<MedicoCreateDto> json) {

        json.forEach(dto -> {
            Medico medico = new Medico(dto);
            medicoRepository.save(medico);
        });

        return ResponseEntity.ok(json.size() + " médicos cadastrados");
    }

    @PutMapping
    public ResponseEntity<MedicoDetailsDto> atualizarMedico(@RequestBody @Valid MedicoUpdateDto json) {
        var medico = medicoRepository.getReferenceById(json.id());
        medico.atualizarCadastro(json);
        medicoRepository.save(medico);
        return ResponseEntity.ok(new MedicoDetailsDto(medico));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> excluirMedico(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluirCadastro();
        medicoRepository.save(medico);
        return ResponseEntity.noContent().build();
    }
}
