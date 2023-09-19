package cloud.training.aws.observability.controller;

import lombok.Data;

@Data
public class CreateCustomerRequest {

    private String email;

    private String name;
}
