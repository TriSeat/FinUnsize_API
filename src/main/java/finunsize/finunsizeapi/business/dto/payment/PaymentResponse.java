package finunsize.finunsizeapi.business.dto.payment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PaymentResponse(
    @NotBlank @Size(max = 70) String nome
) {}
