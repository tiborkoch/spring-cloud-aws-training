package cloud.training.aws.config.controller;

import lombok.Data;

@Data
public class CreateCustomerRequest {

    private String email;

    private String name;
}
