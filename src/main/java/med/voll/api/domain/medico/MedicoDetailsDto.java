package med.voll.api.domain.medico;

import med.voll.api.domain.endereco.Endereco;

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
