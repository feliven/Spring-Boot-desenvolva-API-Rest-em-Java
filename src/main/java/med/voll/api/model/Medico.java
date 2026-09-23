package med.voll.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.MedicoDto;

@Entity
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Column(unique = true)
    private int numeroCrm;
    @Column(unique = true)
    private String enderecoEmail;
    private String numeroTelefone;
    @Embedded
    private Endereco endereco;

    public Medico(MedicoDto medicoDto) {
        this.nome = medicoDto.nome();
        this.especialidade = medicoDto.especialidade();
        this.numeroCrm = medicoDto.numeroCrm();
        this.enderecoEmail = medicoDto.enderecoEmail();
        this.numeroTelefone = medicoDto.numeroTelefone();
        this.endereco = medicoDto.endereco();
    }

    @Override
    public String toString() {
        return "Medico [id=" + id + ", nome=" + nome + ", especialidade=" + especialidade
                + ", numeroCrm=" + numeroCrm + ", enderecoEmail=" + enderecoEmail
                + ", numeroTelefone=" + numeroTelefone + ", endereco=" + endereco + "]";
    }

}
