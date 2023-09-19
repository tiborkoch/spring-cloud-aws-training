package cloud.training.aws.sql.controller;

import java.util.UUID;

import lombok.Data;

@Data
public class CustomerData {

    private UUID id;

    private String email;

    private String name;
}
