package cloud.training.aws.blob.controller;

import cloud.training.aws.blob.domain.ProductType;
import lombok.Data;

@Data
public class CreateProductRequest {

    private String name;

    private String description;

    private String vendor;

    private double price;

    private ProductType type;
}
