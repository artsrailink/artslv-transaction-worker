package co.kereta.api.configuration;

import co.kereta.api.model.DefaultSeatTest;
import co.kereta.api.receiver.ManualSeatMessageHandler;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gemuruhgeo on 08/09/16.
 */
@Configuration
public class RabbitMQConfiguration {
    public static final String queueName = "transaction-queue";
    public static final String exchangeName = "exchange-name";

    @Autowired
    private ManualSeatMessageHandler manualSeatMessageHandler;

    @Bean
    Queue queue(){
        return new Queue(queueName,true,false,false);
    }
    @Bean
    TopicExchange exchange(){
        return new TopicExchange(exchangeName);
    }
    @Bean
    Binding binding(Queue queue,TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(queueName);
    }
    @Bean
    CachingConnectionFactory cachingConnectionFactory(){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setHost("172.16.8.35");
        cachingConnectionFactory.setPort(5672);
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        return cachingConnectionFactory;
    }
    @Bean(name = "rabbitTemplateMod")
    RabbitTemplate rabbitTemplate(CachingConnectionFactory cachingConnectionFactory, MessageConverter ms){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setMessageConverter(ms);

        rabbitTemplate.setConnectionFactory(cachingConnectionFactory);
        return rabbitTemplate;
    }
    @Bean
    public MessageConverter jsonMessageConverter(){
        Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        jackson2JsonMessageConverter.setClassMapper(classMapper());
        return jackson2JsonMessageConverter;
    }

    @Bean
    public DefaultClassMapper classMapper(){
        DefaultClassMapper defaultClassMapper = new DefaultClassMapper();
        defaultClassMapper.setDefaultType(DefaultSeatTest.class);
        return defaultClassMapper;
    }

    public MessageListenerAdapter messageListenerAdapter(){
        return new MessageListenerAdapter(manualSeatMessageHandler,jsonMessageConverter());
    }

    @Bean
    public SimpleMessageListenerContainer listenerContainer(CachingConnectionFactory cachingConnectionFactory,Queue queue) {
        SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer();
        listenerContainer.setConnectionFactory(cachingConnectionFactory);
        listenerContainer.setQueues(queue);
        listenerContainer.setMessageConverter(jsonMessageConverter());
        listenerContainer.setMessageListener(messageListenerAdapter());
        listenerContainer.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return listenerContainer;
    }

}
