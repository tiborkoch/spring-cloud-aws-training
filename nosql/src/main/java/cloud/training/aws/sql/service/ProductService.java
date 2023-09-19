package cloud.training.aws.sql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import cloud.training.aws.sql.controller.ProductData;
import cloud.training.aws.sql.controller.CreateProductRequest;
import cloud.training.aws.sql.domain.Product;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final DynamoDbTemplate dynamoDbTemplate;

    @Override
    public List<ProductData> findAll() {
        PageIterable<Product> pagedProducts = dynamoDbTemplate.scan(ScanEnhancedRequest.builder().build(), Product.class);
        List<Product> allProducts = pagedProducts.stream().flatMap(page -> page.items().stream()).toList();
        List<ProductData> result = new ArrayList<>();
        for (Product product : allProducts) {
            result.add(mapEntityToDto(product));
        }

        return result;
    }

    @Override
    public ProductData save(CreateProductRequest request) {
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setVendor(request.getVendor());
        product.setPrice(request.getPrice());
        product.setType(request.getType());

        Product savedProduct = dynamoDbTemplate.save(product);
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
