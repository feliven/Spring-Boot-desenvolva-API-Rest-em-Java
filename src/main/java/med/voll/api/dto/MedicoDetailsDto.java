package med.voll.api.dto;

import med.voll.api.model.Endereco;
import med.voll.api.model.Especialidade;
import med.voll.api.model.Medico;

public record MedicoDetailsDto(
        Long id,
        String nome,
        Especialidade especialidade,
        Integer numeroCrm,
        String enderecoEmail,
        String numeroTelefone,
        Endereco endereco) {

    public MedicoDetailsDto(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEspecialidade(), medico.getNumeroCrm(),
                medico.getEnderecoEmail(), medico.getNumeroTelefone(), medico.getEndereco());
    }

}
