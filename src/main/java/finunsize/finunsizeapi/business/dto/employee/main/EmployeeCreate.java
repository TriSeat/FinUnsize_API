package finunsize.finunsizeapi.business.dto.employee.main;

import finunsize.finunsizeapi.business.dto.address.AddressCreate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record EmployeeCreate(
        @NotBlank
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF deve conter o seguinte formato: 000.000.000-00")
        String cpf,
        @NotBlank @Size(max = 100) String nome,
        @NotBlank @Size(max = 50) String cargo,
        @NotBlank @Size(max = 20) String turno,
        @NotNull int telefone,
        @NotNull LocalDate admissao,
        AddressCreate endereco,
        @NotNull BigDecimal salario,
        @Size(max = 150) String observacao,
        String url_image
) {}