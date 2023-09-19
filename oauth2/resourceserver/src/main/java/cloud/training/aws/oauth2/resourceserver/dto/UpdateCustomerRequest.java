package cloud.training.aws.oauth2.resourceserver.dto;

import lombok.Data;

@Data
public class UpdateCustomerRequest {

    private String email;

    private String name;
}
