package med.voll.api.dto;

import med.voll.api.model.Endereco;
import med.voll.api.model.Especialidade;

public record MedicoDto(
        String nome,
        Especialidade especialidade,
        int numeroCrm,
        String enderecoEmail,
        String numeroTelefone,
        Endereco endereco) {

}
