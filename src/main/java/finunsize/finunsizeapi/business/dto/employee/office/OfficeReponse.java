package finunsize.finunsizeapi.business.dto.employee.office;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record OfficeReponse(
   @NotBlank @Size(max = 50) String nome,
   @NotBlank @Size(max = 150) String descricao
) {}
