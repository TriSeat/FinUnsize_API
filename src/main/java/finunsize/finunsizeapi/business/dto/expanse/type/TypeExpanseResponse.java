package finunsize.finunsizeapi.business.dto.expanse.type;

import finunsize.finunsizeapi.persistence.model.expanse.TypeExpanseModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record TypeExpanseResponse(
   UUID id_despesa,     
   String nome,
   String descricao
) {
    public TypeExpanseResponse(TypeExpanseModel typeExpanseModel) {
        this(typeExpanseModel.getIdDespesa(), typeExpanseModel.getNome(), typeExpanseModel.getDescricao());
    }
}
