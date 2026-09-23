package med.voll.api.model;

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

    @Override
    public String toString() {
        return "Endereco [logradouro=" + logradouro + ", numeroEndereco=" + numeroEndereco
                + ", complementoEndereco=" + complementoEndereco + ", bairro=" + bairro
                + ", cidade=" + cidade + ", siglaUf=" + siglaUf + ", cep=" + cep + "]";
    }
}
