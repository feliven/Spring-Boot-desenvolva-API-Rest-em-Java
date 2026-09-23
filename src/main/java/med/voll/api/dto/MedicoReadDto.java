package med.voll.api.dto;

import med.voll.api.model.Especialidade;
import med.voll.api.model.Medico;

public record MedicoReadDto(Long id,
        String nome,
        Especialidade especialidade,
        Integer numeroCrm,
        String enderecoEmail) {

    public MedicoReadDto(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEspecialidade(),
                medico.getNumeroCrm(), medico.getEnderecoEmail());
    }
}
