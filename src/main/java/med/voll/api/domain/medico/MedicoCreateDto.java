package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.EnderecoDto;

public record MedicoCreateDto(
        @NotBlank String nome,
        @NotNull Especialidade especialidade,
        @NotNull Integer numeroCrm,
        @NotBlank @Email String enderecoEmail,
        @NotBlank String numeroTelefone,
        @NotNull @Valid EnderecoDto endereco) {

}
