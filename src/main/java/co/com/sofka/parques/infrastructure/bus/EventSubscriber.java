package co.com.sofka.parques.infrastructure.bus;

public interface EventSubscriber {
    void subscribe(String eventType, String exchange);
}