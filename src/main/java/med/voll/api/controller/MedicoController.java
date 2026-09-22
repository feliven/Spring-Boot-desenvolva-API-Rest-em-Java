package med.voll.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.dto.MedicoDto;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    List<MedicoDto> medicos = new ArrayList<MedicoDto>();

    @GetMapping
    public String listarMedicos() {
        return medicos.toString();
    }

    @PostMapping
    public MedicoDto cadastrarMedico(@RequestBody MedicoDto json) {

        this.medicos.add(json);
        System.out.println(json);
        return json;
    }
}
