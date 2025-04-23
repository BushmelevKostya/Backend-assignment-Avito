package avito.backendassignment.service;

import avito.backendassignment.controller.request.ProductsPostRequest;
import avito.backendassignment.exceptions.BadRequestException;
import avito.backendassignment.model.Product;
import avito.backendassignment.model.Reception;
import avito.backendassignment.model.User;
import avito.backendassignment.repository.ProductRepository;
import avito.backendassignment.repository.ReceptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ReceptionRepository receptionRepository;

    public Product addProductToActiveReception(ProductsPostRequest request) {
        Reception activeReception = receptionRepository.findActiveByPvzId(request.getPvzId())
            .orElseThrow(() -> new BadRequestException("Нет активной приёмки на ПВЗ"));
        
        Product product = new Product();
        product.setType(request.getType());
        product.setReceptionId(activeReception.getId());
        product.setDateTime(OffsetDateTime.now());

        return productRepository.save(product);
    }

    public void deleteLastProductFromActiveReception(Long pvzId) {
        Reception activeReception = receptionRepository.findActiveByPvzId(pvzId)
            .orElseThrow(() -> new BadRequestException("Нет активной приёмки на ПВЗ"));

        List<Product> products = productRepository.findByReceptionIdOrderByDateTimeDesc(activeReception.getId());
        if (products.isEmpty()) {
            throw new BadRequestException("Нет товаров для удаления");
        }

        Product lastProduct = products.get(0);
        productRepository.deleteById(lastProduct.getId());
    }
}
