package cloud.training.aws.observability.service;

import java.util.List;

import cloud.training.aws.observability.controller.CreateProductRequest;
import cloud.training.aws.observability.controller.ProductData;

public interface IProductService {

    List<ProductData> findAll();

    ProductData save(CreateProductRequest request);
}
