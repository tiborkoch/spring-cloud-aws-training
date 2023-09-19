package cloud.training.aws.sql.controller;

import lombok.Data;

@Data
public class UpdateCustomerRequest {

    private String email;

    private String name;
}
