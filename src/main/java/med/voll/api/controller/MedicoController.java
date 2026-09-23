package med.voll.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dto.MedicoDto;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public String listarMedicos() {

        List<Medico> medicos = new ArrayList<Medico>();

        medicoRepository.findAll().forEach(medico -> medicos.add(medico));

        String medicosString = "";

        for (int i = 0; i < medicos.size(); i++) {
            medicosString += medicos.get(i) + System.lineSeparator();
        }

        return medicosString;
    }

    @PostMapping
    public Medico cadastrarMedico(@RequestBody @Valid MedicoDto json) {

        System.out.println(json);

        Medico medico = new Medico(json);

        medicoRepository.save(medico);
        return medico;
    }
}
