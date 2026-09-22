package med.voll.api.model;

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
    private int numeroCrm;
    private String enderecoEmail;
    private String numeroTelefone;
    @Embedded
    private Endereco endereco;

    @Override
    public String toString() {
        return "Medico [id=" + id + ", nome=" + nome + ", especialidade=" + especialidade
                + ", numeroCrm=" + numeroCrm + ", enderecoEmail=" + enderecoEmail
                + ", numeroTelefone=" + numeroTelefone + ", endereco=" + endereco + "]";
    }

}
