package finunsize.finunsizeapi.business.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AddressCreate (
        @NotNull @Size(max = 9) int cep,
        @NotBlank String rua,
        @NotBlank String numero,
        @Size(max = 10) String complemento,
        @Size(max = 150) String referencia,
        @NotBlank String cidade
) {}
