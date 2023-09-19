package cloud.training.aws.messaging.consumer.controller;

import cloud.training.aws.messaging.consumer.domain.ProductType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class ProductData {

    private Integer id;

    private String name;

    private String description;

    private String vendor;

    private double price;

    private ProductType type;
}
