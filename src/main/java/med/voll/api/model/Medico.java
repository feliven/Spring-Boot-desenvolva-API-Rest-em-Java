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
import med.voll.api.dto.MedicoCreateDto;
import med.voll.api.dto.MedicoUpdateDto;

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
    private Boolean ativo;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Column(unique = true)
    private Integer numeroCrm;
    @Column(unique = true)
    private String enderecoEmail;
    private String numeroTelefone;
    @Embedded
    private Endereco endereco;

    public Medico(MedicoCreateDto medicoDto) {
        this.ativo = true;
        this.nome = medicoDto.nome();
        this.especialidade = medicoDto.especialidade();
        this.numeroCrm = medicoDto.numeroCrm();
        this.enderecoEmail = medicoDto.enderecoEmail();
        this.numeroTelefone = medicoDto.numeroTelefone();
        this.endereco = new Endereco(medicoDto.endereco());
    }

    public void atualizarCadastro(MedicoUpdateDto dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.numeroTelefone() != null) {
            this.numeroTelefone = dados.numeroTelefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarEndereco(dados.endereco());
        }
    }

    public void excluirCadastro() {
        this.ativo = false;
    }

    @Override
    public String toString() {
        return "Medico [id=" + id + ", nome=" + nome + ", especialidade=" + especialidade
                + ", numeroCrm=" + numeroCrm + ", enderecoEmail=" + enderecoEmail
                + ", numeroTelefone=" + numeroTelefone + ", endereco=" + endereco + "]";
    }

}
