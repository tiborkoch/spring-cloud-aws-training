package cloud.training.aws.messaging.producer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import io.awspring.cloud.sns.annotation.endpoint.NotificationMessageMapping;
import io.awspring.cloud.sns.annotation.endpoint.NotificationSubscriptionMapping;
import io.awspring.cloud.sns.annotation.endpoint.NotificationUnsubscribeConfirmationMapping;
import io.awspring.cloud.sns.annotation.handlers.NotificationMessage;
import io.awspring.cloud.sns.annotation.handlers.NotificationSubject;
import io.awspring.cloud.sns.handlers.NotificationStatus;

@Controller
public class NotificationMappingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationMappingController.class);

    @NotificationSubscriptionMapping(path = "/testTopic")
    public void handleSubscriptionMessage(NotificationStatus status) {
        LOGGER.info("Subscribed!!!");
        status.confirmSubscription();
    }

    @NotificationMessageMapping(path = "/testTopic")
    public void handleNotificationMessage(@NotificationSubject String subject, @NotificationMessage String message) {
        LOGGER.info("NotificationMessageMapping message is: {}", message);
        LOGGER.info("NotificationMessageMapping subject is: {}", subject);
    }

    @NotificationUnsubscribeConfirmationMapping(path = "/testTopic")
    public void handleUnsubscribeMessage(NotificationStatus status) {
        LOGGER.info("UNSubscribed!!!");
        status.confirmSubscription();
    }

}