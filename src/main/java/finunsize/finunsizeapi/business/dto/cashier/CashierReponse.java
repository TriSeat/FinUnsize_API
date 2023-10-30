package finunsize.finunsizeapi.business.dto.cashier;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CashierReponse(
        int Id,
        @NotBlank @Size (max = 50) String nome,
        @NotBlank @Size (max = 10) String status) {
}
