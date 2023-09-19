package cloud.training.aws.messaging.consumer.listener;

import java.time.OffsetDateTime;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import cloud.training.aws.messaging.consumer.service.ICustomerService;
import cloud.training.aws.messaging.consumer.controller.CreateCustomerRequest;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomerListener {

    private final ICustomerService customerService;

    @SqsListener("testQueue")
    public void listen(Message<CreateCustomerRequest> message) {
        log.info("Message received {} on listen method at {}", message.getPayload(), OffsetDateTime.now());
        customerService.save(message.getPayload());
    }
}
