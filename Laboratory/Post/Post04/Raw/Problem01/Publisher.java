public interface Publisher {
    void addSubscriber(Subscriber s);

    void removeSubscriber(Subscriber s);

    void broadcast(String message, String category);
}
