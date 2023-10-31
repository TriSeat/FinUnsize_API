package finunsize.finunsizeapi.business.dto.user.main;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserLogin(
   @NotBlank @Size(max = 70) String login,
   @NotBlank String password
) {}
