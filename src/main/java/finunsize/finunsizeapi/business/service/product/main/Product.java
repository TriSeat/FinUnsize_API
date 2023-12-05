package finunsize.finunsizeapi.business.service.product.main;

import finunsize.finunsizeapi.business.configuration.handler.EntityAlreadyExistsException;
import finunsize.finunsizeapi.business.dto.product.main.ProductCreate;
import finunsize.finunsizeapi.business.dto.product.main.ProductReponse;
import finunsize.finunsizeapi.business.dto.product.main.ProductUpdate;
import finunsize.finunsizeapi.business.service.product.InfoProductService;
import finunsize.finunsizeapi.integration.auth.UserSession;
import finunsize.finunsizeapi.persistence.model.product.InfoProductModel;
import finunsize.finunsizeapi.persistence.model.product.ProductModel;
import finunsize.finunsizeapi.persistence.repository.product.ProductRepository;
import finunsize.finunsizeapi.persistence.repository.product.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Product implements ProductService {

    private final ProductRepository productRepository;
    private final InfoProductService infoProductService;
    private final SupplierRepository supplierRepository;
    private final UserSession userSession;

    @Autowired
    public Product (ProductRepository productRepository, InfoProductService infoProductService, SupplierRepository supplierRepository, UserSession userSession) {
        this.productRepository = productRepository;
        this.infoProductService = infoProductService;
        this.supplierRepository = supplierRepository;
        this.userSession = userSession;
    }

    @Transactional
    @Override
    public ProductModel create(@Valid ProductCreate productCreate) {
        var product = new ProductModel();
        BeanUtils.copyProperties(productCreate, product);
        var info = infoProductService.create(productCreate.informacoes());
        product.setCodBarras(productCreate.cod_barras());
        insertFk(product, productCreate.fornecedor(), info);
        saveDate(product);
        valid(product.getCodBarras());
        return productRepository.save(product);
    }

    @Override
    public ProductReponse find(String name) {
        var product = productRepository.findByNomeAndCnpj(name, userSession.getSessionCnpj())
                .orElseThrow(() -> new EntityNotFoundException(String.format("Produto com o nome: %s, não encontrado", name)));
        return new ProductReponse(product);
    }

    @Override
    public ProductReponse findByCod(String barras) {
        var product = productRepository.findById(barras)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Produto com o nome: %s, não encontrado", barras)));
        return  new ProductReponse(product);
    }

    @Override
    public List<ProductReponse> list() {
        List<ProductModel> product = productRepository.findByCnpj(userSession.getSessionCnpj());
        List<ProductReponse> response = product
                .stream()
                .map(ProductReponse::new)
                .collect(Collectors.toList());
        return response;
    }

    @Transactional
    @Override
    public ProductModel update(String barras, @Valid ProductUpdate productUpdate) {
        var product = productRepository.findByCodBarrasAndCnpj(barras, userSession.getSessionCnpj())
                .orElseThrow(() -> new EntityNotFoundException(String.format("Funcionário com o cpf de: %s não foi encontrado", barras)));
        BeanUtils.copyProperties(productUpdate, product);
        infoProductService.update(product.getInformacoes().getIdItemProduto(), productUpdate.informacoes());
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public void delete(String barras) {
        var product = productRepository.findById(barras)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Produto com o código de barras: %s não foi encontrado", barras)));
        productRepository.delete(product);
        infoProductService.delete(product.getInformacoes().getIdItemProduto());
    }


    private void valid(String barras) {
        var product = productRepository.existsByCodBarrasAndCnpj(barras, userSession.getSessionCnpj());
        if (product)
            throw new EntityAlreadyExistsException(String.format("O produto já foi cadastrado", product));
    }

    private void insertFk(ProductModel productModel, String name, InfoProductModel infoProduct) {
        var supplier = supplierRepository.findByNomeAndCnpj(name, userSession.getSessionCnpj())
                .orElseThrow(() -> new EntityNotFoundException(String.format("Fornecedor com o nome: %s não foi encontrado", name)));
        productModel.setFornecedor(supplier);
        productModel.setInformacoes(infoProduct);
        productModel.setCnpj(userSession.getSessionCnpj());
    }

    private void saveDate(ProductModel productModel) {
        LocalDate date = LocalDate.now();
        productModel.setData_cadastro(date);
    }
}
