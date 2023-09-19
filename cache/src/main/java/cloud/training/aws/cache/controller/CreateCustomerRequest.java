package cloud.training.aws.cache.controller;

import lombok.Data;

@Data
public class CreateCustomerRequest {

    private String email;

    private String name;
}
