package cloud.training.aws.blob.service;

import java.util.List;

import cloud.training.aws.blob.controller.CreateProductRequest;
import cloud.training.aws.blob.controller.ProductData;

public interface IProductService {

    List<ProductData> findAll();

    ProductData save(CreateProductRequest request);
}
