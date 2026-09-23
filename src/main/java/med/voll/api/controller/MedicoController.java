package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dto.MedicoCreateDto;
import med.voll.api.dto.MedicoReadDto;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public Page<MedicoReadDto> listarMedicos(
            @PageableDefault(size = 3, sort = { "numeroCrm" }, direction = Direction.DESC) Pageable paginacao) {

        return medicoRepository.findAll(paginacao).map(MedicoReadDto::new);
    }

    @PostMapping
    public Medico cadastrarMedico(@RequestBody @Valid MedicoCreateDto json) {

        Medico medico = new Medico(json);
        medicoRepository.save(medico);
        return medico;
    }
}
