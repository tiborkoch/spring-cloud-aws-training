package cloud.training.aws.sql.service;

import java.util.List;
import java.util.UUID;

import cloud.training.aws.sql.controller.CreateCustomerRequest;
import cloud.training.aws.sql.controller.UpdateCustomerRequest;
import cloud.training.aws.sql.controller.CustomerData;

public interface ICustomerService {

    CustomerData save(CreateCustomerRequest request);

    CustomerData update(UUID id, UpdateCustomerRequest request);

    List<CustomerData> findAll();

    CustomerData findById(UUID id);

    void delete(UUID id);
}
