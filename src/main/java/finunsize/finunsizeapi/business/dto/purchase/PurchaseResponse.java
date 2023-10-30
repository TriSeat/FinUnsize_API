package finunsize.finunsizeapi.business.dto.purchase;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PurchaseResponse(
   @NotBlank @Size(max = 50) String nome,
   @NotBlank String pagamento,
   BigDecimal preco_total,
   @NotBlank @DateTimeFormat(pattern = "dd-MM-yyy") LocalDateTime data,
   @NotBlank List<PurchaseItemResponse> purchaseItem,
   @NotBlank String fornecedor
) {}
