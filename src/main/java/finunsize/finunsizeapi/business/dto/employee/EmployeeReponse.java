package finunsize.finunsizeapi.business.dto.employee;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record EmployeeReponse(
        @NotBlank @Size(max = 100) String nome,
        @NotBlank @Size(max = 50) String cargo,
        @NotBlank @Size(max = 20) String turno,
        int telefone,
        @NotBlank String rua,
        BigDecimal salario,
        @NotBlank @Size(max = 150) String observacao,
        @Size(max = 8) String status
) { }
