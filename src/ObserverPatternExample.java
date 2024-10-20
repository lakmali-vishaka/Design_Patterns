
import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(String message);
}

// Concrete Observer: Subscriber
class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

// Subject interface
interface Subject {
    void addObserver(Observer observer);
    void notifyObservers(String message);
}

// Concrete Subject: Publisher
class Publisher implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(String message) {
        observers.forEach(observer -> observer.update(message));
    }

    // Publish method to notify all observers
    public void publish(String message) {
        System.out.println("Publishing: " + message);
        notifyObservers(message);
    }
}

// Usage example
public class ObserverPatternExample {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();

        // Create subscribers
        Subscriber alice = new Subscriber("Alice");
        Subscriber bob = new Subscriber("Bob");

        // Add subscribers to publisher
        publisher.addObserver(alice);
        publisher.addObserver(bob);

        // Publish messages
        publisher.publish("Hello!");
        publisher.publish("How are you?");

        // Bob unsubscribes
        publisher.addObserver(new Subscriber("Charlie")); // Charlie subscribed late
        publisher.publish("Charlie's message.");
    }
}
