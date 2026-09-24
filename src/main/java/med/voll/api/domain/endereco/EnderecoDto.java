package med.voll.api.domain.endereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoDto(
        @NotBlank String logradouro,
        String numeroEndereco,
        String complementoEndereco,
        @NotBlank String bairro,
        @NotBlank String cidade,
        @NotNull @Valid SiglaUf siglaUf,
        @NotBlank @Pattern(regexp = "\\d{8}") String cep) {

}
