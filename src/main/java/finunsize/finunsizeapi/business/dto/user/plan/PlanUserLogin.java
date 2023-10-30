package finunsize.finunsizeapi.business.dto.user.plan;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PlanUserLogin(
   @NotBlank @Size(max = 50) String nome,
   @NotBlank String password
) {}
