package med.voll.api.model;

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
    private String numeroEndereco;
    private String complementoEndereco;
    private String cidade;
    @Enumerated(EnumType.STRING)
    private SiglaUf siglaUf;
    private String cep;

    @Override
    public String toString() {
        return "Endereco [logradouro=" + logradouro + ", numeroEndereco=" + numeroEndereco
                + ", complementoEndereco=" + complementoEndereco + ", cidade=" + cidade
                + ", siglaUf=" + siglaUf + ", cep=" + cep + "]";
    }
}
