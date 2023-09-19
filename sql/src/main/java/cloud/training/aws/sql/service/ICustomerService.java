package cloud.training.aws.sql.service;

import java.util.List;

import cloud.training.aws.sql.controller.CreateCustomerRequest;
import cloud.training.aws.sql.controller.CustomerData;
import cloud.training.aws.sql.controller.UpdateCustomerRequest;

public interface ICustomerService {

    CustomerData save(CreateCustomerRequest request);

    CustomerData update(Integer id, UpdateCustomerRequest request);

    List<CustomerData> findAll();

    CustomerData findById(Integer id);

    void delete(Integer id);
}
