package cloud.training.aws.messaging.consumer.service;

import java.util.List;

import cloud.training.aws.messaging.consumer.controller.CreateProductRequest;
import cloud.training.aws.messaging.consumer.controller.ProductData;

public interface IProductService {

    List<ProductData> findAll();

    ProductData save(CreateProductRequest request);
}
