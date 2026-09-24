package med.voll.api.domain.endereco;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    @Column(nullable = true)
    private String numeroEndereco;
    @Column(nullable = true)
    private String complementoEndereco;
    private String bairro;
    private String cidade;
    @Enumerated(EnumType.STRING)
    private SiglaUf siglaUf;
    private String cep;

    public Endereco(EnderecoDto enderecoDto) {
        this.logradouro = enderecoDto.logradouro();
        this.numeroEndereco = enderecoDto.numeroEndereco();
        this.complementoEndereco = enderecoDto.complementoEndereco();
        this.bairro = enderecoDto.bairro();
        this.cidade = enderecoDto.cidade();
        this.siglaUf = enderecoDto.siglaUf();
        this.cep = enderecoDto.cep();
    }

    public void atualizarEndereco(EnderecoDto dados) {
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }

        if (dados.numeroEndereco() != null) {
            this.numeroEndereco = dados.numeroEndereco();
        }

        if (dados.complementoEndereco() != null) {
            this.complementoEndereco = dados.complementoEndereco();
        }

        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }

        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }

        if (dados.siglaUf() != null) {
            this.siglaUf = dados.siglaUf();
        }

        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
    }

    @Override
    public String toString() {
        return "Endereco [logradouro=" + logradouro + ", numeroEndereco=" + numeroEndereco
                + ", complementoEndereco=" + complementoEndereco + ", bairro=" + bairro
                + ", cidade=" + cidade + ", siglaUf=" + siglaUf + ", cep=" + cep + "]";
    }
}
