package cloud.training.aws.blob.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix = "application")
@Component
@Data
public class ApplicationConfiguration {

    private String bucketName;
}
