package co.com.sofka.parques.infrastructure.bus;

import co.com.sofka.application.ApplicationEventDrive;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.infraestructure.event.EventSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.concurrent.Flow;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class EventListenerSubscriber implements Flow.Subscriber<DomainEvent> {
    private static final Logger logger = Logger.getLogger(EventListenerSubscriber.class.getName());

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ApplicationEventDrive applicationEventDrive;
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        subscription.request(1);
        this.subscription = subscription;
    }

    @Override
    public void onNext(DomainEvent event) {
        logger.log(Level.INFO, "Process event {0}", EventSerializer.instance().serialize(event));
        applicationEventPublisher.publishEvent(event);
        applicationEventDrive.fire(event);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        logger.log(Level.SEVERE, throwable.getMessage());
    }

    @Override
    public void onComplete() {
    }

}