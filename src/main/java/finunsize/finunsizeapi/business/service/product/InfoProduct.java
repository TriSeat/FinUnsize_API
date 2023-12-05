package finunsize.finunsizeapi.business.service.product;

import finunsize.finunsizeapi.business.dto.product.InfoProduct.InfoProductCreate;
import finunsize.finunsizeapi.business.dto.product.InfoProduct.InfoProductUpdate;
import finunsize.finunsizeapi.persistence.model.product.InfoProductModel;
import finunsize.finunsizeapi.persistence.repository.product.InfoProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InfoProduct implements InfoProductService {

    private final InfoProductRepository infoProductRepository;

    public InfoProduct(InfoProductRepository infoProductRepository) {
        this.infoProductRepository = infoProductRepository;
    }

    @Transactional
    @Override
    public InfoProductModel create(@Valid InfoProductCreate infoProductCreate) {
        var infoProductModel = new InfoProductModel();
        BeanUtils.copyProperties(infoProductCreate, infoProductModel, "id_item_produto");
        return infoProductRepository.save(infoProductModel);
    }

    @Transactional
    @Override
    public InfoProductModel update(UUID id, @Valid InfoProductUpdate infoProductUpdate) {
        var info = infoProductRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("A informação com o id %s não foi encontrado", id.toString())));
        BeanUtils.copyProperties(infoProductUpdate, info, "id_item_produto");
        return infoProductRepository.save(info);
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        var info = infoProductRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("A informação com o id %s não foi encontrado", id.toString())));
        infoProductRepository.delete(info);
    }
}
