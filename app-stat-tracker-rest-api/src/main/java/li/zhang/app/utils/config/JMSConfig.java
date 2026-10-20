package li.zhang.app.utils.config;

import jakarta.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.support.converter.JacksonJsonMessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
@EnableJms
public class JMSConfig {
    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        // Switch to the Jackson 3 compatible version
        JacksonJsonMessageConverter converter = new JacksonJsonMessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }


    @Bean
    public CachingConnectionFactory cachingConnectionFactory() {
        // Instantiate your underlying broker connection factory
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");

        CachingConnectionFactory cachingFactory = new CachingConnectionFactory(activeMQConnectionFactory);
        cachingFactory.setClientId("my-application-client-id");
        return cachingFactory;
    }

    @Bean
    public JmsListenerContainerFactory<?> durableJmsContainerFactory(CachingConnectionFactory cachingConnectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(cachingConnectionFactory);
        factory.setPubSubDomain(true);
        factory.setSubscriptionDurable(true);

        return factory;
    }
}
