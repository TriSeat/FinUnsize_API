package finunsize.finunsizeapi.business.dto.expanse;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TypeExpanseResponse(
   @NotBlank @Size(max = 50) String nome,
   @NotBlank @Size(max = 150) String descricao
) {}
