package li.zhang.app.services.base;

import li.zhang.app.persistence.entity.events.AccountActivationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AccountConfirmProcessingService {
    private static final Logger log = LoggerFactory.getLogger(AccountConfirmProcessingService .class);

    // add email service,
    // add event DAO'
    // add constructor


    @JmsListener(destination = "${app.queue.account.confirm}")
    public void receiveMailTask(AccountActivationEvent event) {
        log.info("Received background mail task for: {}", event.getConfirmationAddress());
        log.info("Subject: {}", event.getActivationCode());
        log.info("Body processing: {}", event.getUserInfoID());

        // send the email confirmation to user's address
        // store code into database for look and user verification

    }
}
