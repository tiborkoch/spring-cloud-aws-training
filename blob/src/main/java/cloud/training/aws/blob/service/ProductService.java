package cloud.training.aws.blob.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cloud.training.aws.blob.controller.CreateProductRequest;
import cloud.training.aws.blob.controller.ProductData;
import cloud.training.aws.blob.domain.Product;
import cloud.training.aws.blob.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductData> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductData> result = new ArrayList<>();
        for (Product product : products) {
            result.add(mapEntityToDto(product));
        }

        return result;
    }

    @Override
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
