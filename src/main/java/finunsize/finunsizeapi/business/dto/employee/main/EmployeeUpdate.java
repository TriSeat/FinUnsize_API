package finunsize.finunsizeapi.business.dto.employee.main;

import finunsize.finunsizeapi.business.dto.address.AddressUpdate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeUpdate(
        @Pattern(regexp = "\\\\d{3}\\\\.\\\\d{3}\\\\.\\\\d{3}-\\\\d{2}", message = "O CPF deve conter o seguinte formato: 000.000.000-00")
        String cpf,
        @NotBlank @Size(max = 100) String nome,
        @NotBlank @Size(max = 50) String cargo,
        @NotBlank @Size(max = 20) String turno,
        @NotNull int telefone,
        @NotNull LocalDate admissao,
        AddressUpdate addressUpdate,
        @NotNull BigDecimal salario,
        @Size(max = 150) String observacao,
        boolean demitido,
        String url_image
) {}
