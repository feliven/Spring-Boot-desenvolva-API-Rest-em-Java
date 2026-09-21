package med.voll.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.model.Medico;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    List<Medico> medicos = new ArrayList<Medico>();
    List<String> teste = new ArrayList<String>();

    @GetMapping
    public String listarTeste() {
        return teste.toString();
    }

    @PostMapping()
    public String cadastrarTeste() {
        this.teste.add("teste" + (this.teste.size() + 1));
        return "Médico cadastrado";
    }

    @GetMapping("/real")
    public String listarMedicos() {
        return medicos.toString();
    }

    @PostMapping("/real")
    public String cadastrarMedico(Medico medico) {
        this.medicos.add(medico);
        return "Médico cadastrado";
    }
}
