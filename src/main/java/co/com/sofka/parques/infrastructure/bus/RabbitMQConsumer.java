package co.com.sofka.parques.infrastructure.bus;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.infraestructure.DeserializeEventException;
import co.com.sofka.infraestructure.bus.serialize.SuccessNotificationSerializer;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.concurrent.Flow;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class RabbitMQConsumer implements Flow.Subscription {
    private static final Logger logger = Logger.getLogger(RabbitMQConsumer.class.getName());

    private final Flow.Subscriber<DomainEvent> eventSubscriber;

    @Autowired
    public RabbitMQConsumer(EventListenerSubscriber eventSubscriber) {
        this.eventSubscriber = eventSubscriber;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "juego.handles", durable = "true"),
            exchange = @Exchange(value = "core-nomemientas", type = "topic"),
            key = "nomemientan.juego.#"
    ))

    public void recievedMessageSlack(Message<String> message) {
        localReplay(message);
    }

    private void localReplay(Message<String> peyload) {
        try {
            String message = peyload.getPayload();
            var notification = SuccessNotificationSerializer.instance().deserialize(message);
            var event = notification.deserializeEvent();
            logger.log(Level.INFO, "###### Recibe message form {0} -- {1}", new String[]{event.type, event.getClass().getName()});
            eventSubscriber.onSubscribe(this);
            eventSubscriber.onNext(event);
        } catch (DeserializeEventException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            eventSubscriber.onError(e);
        }
    }

    @Override
    public void request(long n) {

    }

    @Override
    public void cancel() {

    }
}