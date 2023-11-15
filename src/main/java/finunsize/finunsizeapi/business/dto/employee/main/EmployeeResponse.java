package finunsize.finunsizeapi.business.dto.employee.main;

import finunsize.finunsizeapi.business.dto.address.AddressResponse;
import finunsize.finunsizeapi.persistence.model.employee.EmployeeModel;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeResponse(
        int id_funcionario,
        String cpf,
        String nome,
        String cargo,
        String turno,
        int telefone,
        LocalDate admissao,
        AddressResponse endereco,
        BigDecimal salario,
        String observacao,
        boolean demitido,
        String url_image
) {
    public EmployeeResponse(EmployeeModel employee) {
        this(employee.getIdFuncionario(), employee.getCpf(), employee.getNome(),
                employee.getCargo().getNome(),
                employee.getTurno(), employee.getTelefone(), LocalDate.from(employee.getAdmissao()),
                new AddressResponse(
                        employee.getId_logradouro().getId_logradouro(),
                        employee.getId_logradouro().getCep(),
                        employee.getId_logradouro().getRua(),
                        employee.getId_logradouro().getNumero(),
                        employee.getId_logradouro().getComplemento(),
                        employee.getId_logradouro().getReferencia(),
                        employee.getId_logradouro().getCidade()
                ),
                employee.getSalario(), employee.getObservacao(), employee.isDemitido(), employee.getUrl_image());
    }
}
