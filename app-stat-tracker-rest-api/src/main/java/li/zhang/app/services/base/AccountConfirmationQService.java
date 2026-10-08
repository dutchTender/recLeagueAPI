package li.zhang.app.services.base;


import li.zhang.app.persistence.entity.events.AccountActivationEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsClient;
import org.springframework.stereotype.Service;

@Service
public class AccountConfirmationQService {

    private final JmsClient jmsClient;

    @Value("${app.queue.account.confirm}")
    private String mailQueue;

    // Inject the new fluent JmsClient API
    public AccountConfirmationQService(JmsClient jmsClient) {
        this.jmsClient = jmsClient;
    }


    public void sendToQueue(AccountActivationEvent event) {
        // Leverages Spring Boot 4's clean, fluent messaging syntax
        this.jmsClient.destination(mailQueue)
                .send(event);
    }
}
