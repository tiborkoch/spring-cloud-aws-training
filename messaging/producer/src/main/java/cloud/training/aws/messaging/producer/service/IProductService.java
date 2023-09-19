package cloud.training.aws.messaging.producer.service;

import java.util.List;

import cloud.training.aws.messaging.producer.controller.CreateProductRequest;
import cloud.training.aws.messaging.producer.controller.ProductData;

public interface IProductService {

    List<ProductData> findAll();

    ProductData save(CreateProductRequest request);
}
