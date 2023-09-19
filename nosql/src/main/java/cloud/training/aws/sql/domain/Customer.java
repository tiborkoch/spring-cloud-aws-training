package cloud.training.aws.sql.domain;

import java.util.UUID;

import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@Setter
@NoArgsConstructor
@DynamoDbBean
public class Customer {

    private UUID id;

    private String email;

    private String name;

    @DynamoDbPartitionKey
    public UUID getId() {
        return id;
    }

    @DynamoDbAttribute("email")
    public String getEmail() {
        return email;
    }

    @DynamoDbAttribute("name")
    public String getName() {
        return name;
    }
}
