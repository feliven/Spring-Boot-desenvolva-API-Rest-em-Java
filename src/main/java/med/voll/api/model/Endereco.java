package med.voll.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.EnderecoDto;

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

    @Override
    public String toString() {
        return "Endereco [logradouro=" + logradouro + ", numeroEndereco=" + numeroEndereco
                + ", complementoEndereco=" + complementoEndereco + ", bairro=" + bairro
                + ", cidade=" + cidade + ", siglaUf=" + siglaUf + ", cep=" + cep + "]";
    }
}
