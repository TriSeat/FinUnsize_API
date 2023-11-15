package finunsize.finunsizeapi.business.dto.employee.office;

import finunsize.finunsizeapi.persistence.model.employee.OfficeModel;

import java.util.UUID;

public record OfficeResponse(
   UUID id_cargo,
   String nome,
   String descricao
) {
    public OfficeResponse(OfficeModel officeModel) {
        this(officeModel.getIdCargo(), officeModel.getNome(), officeModel.getDescricao());
    }
}
