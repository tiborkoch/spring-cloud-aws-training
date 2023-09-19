package cloud.training.aws.sql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import cloud.training.aws.sql.controller.CreateCustomerRequest;
import cloud.training.aws.sql.controller.UpdateCustomerRequest;
import cloud.training.aws.sql.controller.CustomerData;
import cloud.training.aws.sql.domain.Customer;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.TransactWriteItemsEnhancedRequest;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final DynamoDbTemplate dynamoDbTemplate;
    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;

    private DynamoDbTable<Customer> customerTable;

    @PostConstruct
    public void init() {
        customerTable = dynamoDbEnhancedClient.table("customer", TableSchema.fromBean(Customer.class));
    }

    @Override
    public CustomerData save(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID());
        customer.setEmail(request.getEmail());
        customer.setName(request.getName());

        dynamoDbEnhancedClient.transactWriteItems(TransactWriteItemsEnhancedRequest.builder()
                .addPutItem(customerTable, customer)
                .build());
        return mapEntityToDto(customer);
    }

    @Override
    public CustomerData update(UUID id, UpdateCustomerRequest request) {
        Key key = Key.builder().partitionValue(id.toString()).build();
        Customer customer = dynamoDbTemplate.load(key, Customer.class);

        customer.setEmail(request.getEmail());
        customer.setName(request.getName());
        dynamoDbTemplate.update(customer);

        return mapEntityToDto(customer);
    }

    @Override
    public List<CustomerData> findAll() {
        PageIterable<Customer> pagedCustomers = dynamoDbTemplate.scan(ScanEnhancedRequest.builder().build(), Customer.class);
        List<Customer> allCustomers = pagedCustomers.stream().flatMap(page -> page.items().stream()).toList();
        List<CustomerData> result = new ArrayList<>();
        for (Customer customer : allCustomers) {
            result.add(mapEntityToDto(customer));
        }

        return result;
    }

    @Override
    public CustomerData findById(UUID id) {
        PageIterable<Customer> customers = dynamoDbTemplate.query(
                QueryEnhancedRequest.builder()
                        .queryConditional(QueryConditional
                                .keyEqualTo(Key.builder().partitionValue(id.toString()).build()))
                        .limit(1)
                        .build(),
                Customer.class);

        return mapEntityToDto(customers.iterator().next().items().get(0));
    }

    @Override
    public void delete(UUID id) {
        Key keyToDelete = Key.builder().partitionValue(id.toString()).build();
        dynamoDbTemplate.delete(keyToDelete, Customer.class);
    }

    private CustomerData mapEntityToDto(Customer customer) {
        CustomerData data = new CustomerData();
        data.setId(customer.getId());
        data.setEmail(customer.getEmail());
        data.setName(customer.getName());
        return data;
    }
}
