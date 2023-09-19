package cloud.training.aws.cache.service;

import java.util.List;

import cloud.training.aws.cache.controller.ProductData;
import cloud.training.aws.cache.controller.CreateProductRequest;

public interface IProductService {

    List<ProductData> findAll();

    ProductData save(CreateProductRequest request);
}
