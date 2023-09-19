package cloud.training.aws.config.controller;

import lombok.Data;

@Data
public class UpdateCustomerRequest {

    private String email;

    private String name;
}
