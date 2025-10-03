public interface Subscriber {
    void receive(String agencyName, String message, String category);
}
