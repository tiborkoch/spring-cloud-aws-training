package cloud.training.aws.oauth2.resourceserver.dto;

import lombok.Data;

@Data
public class CustomerData {

    private Integer id;

    private String email;

    private String name;
}
