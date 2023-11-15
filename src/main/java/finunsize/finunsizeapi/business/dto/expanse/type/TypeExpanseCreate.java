package finunsize.finunsizeapi.business.dto.expanse.type;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TypeExpanseCreate (
    @NotBlank String nome,
    @NotBlank @Size(max = 150) String descricao
) {}
