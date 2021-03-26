package co.com.sofka.parques.infrastructure.config;

import co.com.sofka.application.ApplicationCommandExecutor;
import co.com.sofka.application.ApplicationEventDrive;
import co.com.sofka.infraestructure.asyn.SubscriberEvent;
import co.com.sofka.infraestructure.bus.EventBus;
import co.com.sofka.infraestructure.repository.EventStoreRepository;
import co.com.sofka.parques.infrastructure.repo.MongoEventStoreRepository;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import java.net.URI;

@Configuration
public class CommandConfiguration {

    private static final String PACKAGE_USE_CASE = "co.com.sofka.parques.usecase";

    @Bean
    public SubscriberEvent subscriberEvent(EventStoreRepository eventStoreRepository, EventBus eventBus) {
        return new SubscriberEvent(eventStoreRepository, eventBus);
    }

    @Bean
    public EventStoreRepository eventStoreRepository(@Qualifier("mongoTemplateCommand") MongoTemplate mongoTemplate) {
        return new MongoEventStoreRepository(mongoTemplate);
    }

    @Bean
    public ApplicationCommandExecutor applicationCommandExecutor(SubscriberEvent subscriberEvent, EventStoreRepository eventStoreRepository) {
        return new ApplicationCommandExecutor(PACKAGE_USE_CASE, subscriberEvent, eventStoreRepository);
    }

    @Bean
    public ApplicationEventDrive applicationEventDrive(SubscriberEvent subscriberEvent, EventStoreRepository eventStoreRepository) {
        return new ApplicationEventDrive(PACKAGE_USE_CASE, subscriberEvent, eventStoreRepository);
    }

    @Bean
    public ConnectionFactory connectionFactory(@Value("${spring.bus.uri}") String uri) {
        return new CachingConnectionFactory(URI.create(uri));
    }

    @Bean
    public RabbitAdmin rabbitAdmin(final ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean("mongoTemplateCommand")
    @Primary
    public MongoTemplate mongoTemplateCommand(@Value("${spring.commands.uri}") String uri)  {
        ConnectionString connectionString = new ConnectionString(uri);
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(connectionString));
    }

    @Bean("mongoTemplateQueries")
    public MongoTemplate mongoTemplateQueries(@Value("${spring.queries.uri}") String uri)  {
        ConnectionString connectionString = new ConnectionString(uri);
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(connectionString));
    }
}