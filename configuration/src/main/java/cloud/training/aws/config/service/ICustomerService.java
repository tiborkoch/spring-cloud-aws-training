package cloud.training.aws.config.service;

import java.util.List;

import cloud.training.aws.config.controller.CreateCustomerRequest;
import cloud.training.aws.config.controller.CustomerData;
import cloud.training.aws.config.controller.UpdateCustomerRequest;

public interface ICustomerService {

    CustomerData save(CreateCustomerRequest request);

    CustomerData update(Integer id, UpdateCustomerRequest request);

    List<CustomerData> findAll();

    CustomerData findById(Integer id);

    void delete(Integer id);
}
