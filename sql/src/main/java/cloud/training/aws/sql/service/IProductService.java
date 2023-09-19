package cloud.training.aws.sql.service;

import java.util.List;

import cloud.training.aws.sql.controller.CreateProductRequest;
import cloud.training.aws.sql.controller.ProductData;

public interface IProductService {

    List<ProductData> findAll();

    ProductData findById(Integer id);

    ProductData save(CreateProductRequest request);

    void delete(Integer id);
}
