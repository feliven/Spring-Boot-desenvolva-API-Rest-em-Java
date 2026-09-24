package med.voll.api.domain.medico;

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
