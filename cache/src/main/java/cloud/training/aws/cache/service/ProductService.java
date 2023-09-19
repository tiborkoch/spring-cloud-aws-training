package cloud.training.aws.cache.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cloud.training.aws.cache.controller.ProductData;
import cloud.training.aws.cache.repository.ProductRepository;
import cloud.training.aws.cache.controller.CreateProductRequest;
import cloud.training.aws.cache.domain.Product;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Override
    @Cacheable(value = "products")
    public List<ProductData> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductData> result = new ArrayList<>();
        for (Product product : products) {
            result.add(mapEntityToDto(product));
        }

        return result;
    }

    @Override
    // TODO - add annotations to update the cache with the new product
    public ProductData save(CreateProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setVendor(request.getVendor());
        product.setPrice(request.getPrice());
        product.setType(request.getType());

        Product savedProduct = productRepository.save(product);
        return mapEntityToDto(savedProduct);
    }

    private ProductData mapEntityToDto(Product product) {
        ProductData data = new ProductData();
        data.setId(product.getId());
        data.setName(product.getName());
        data.setDescription(product.getDescription());
        data.setVendor(product.getVendor());
        data.setPrice(product.getPrice());
        data.setType(product.getType());
        return data;
    }
}
