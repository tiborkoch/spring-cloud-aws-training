package cloud.training.aws.observability.service;

import java.util.List;

import cloud.training.aws.observability.controller.CreateCustomerRequest;
import cloud.training.aws.observability.controller.CustomerData;
import cloud.training.aws.observability.controller.UpdateCustomerRequest;

public interface ICustomerService {

    CustomerData save(CreateCustomerRequest request);

    CustomerData update(Integer id, UpdateCustomerRequest request);

    List<CustomerData> findAll();

    CustomerData findById(Integer id);

    void delete(Integer id);
}
