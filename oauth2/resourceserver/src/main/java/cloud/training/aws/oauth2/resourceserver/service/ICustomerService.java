package cloud.training.aws.oauth2.resourceserver.service;

import java.util.List;

import cloud.training.aws.oauth2.resourceserver.dto.CreateCustomerRequest;
import cloud.training.aws.oauth2.resourceserver.dto.CustomerData;
import cloud.training.aws.oauth2.resourceserver.dto.UpdateCustomerRequest;

public interface ICustomerService {

    CustomerData save(CreateCustomerRequest request);

    CustomerData update(Integer id, UpdateCustomerRequest request);

    List<CustomerData> findAll();

    CustomerData findById(Integer id);

    void delete(Integer id);
}
