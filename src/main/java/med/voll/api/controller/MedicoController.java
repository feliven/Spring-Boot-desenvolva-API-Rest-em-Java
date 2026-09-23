package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<MedicoReadDto> listarMedicos() {

        return medicoRepository.findAll().stream().map(MedicoReadDto::new).toList();
    }

    @PostMapping
    public Medico cadastrarMedico(@RequestBody @Valid MedicoCreateDto json) {

        Medico medico = new Medico(json);
        medicoRepository.save(medico);
        return medico;
    }
}
