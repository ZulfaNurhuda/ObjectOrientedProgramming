public interface User {
    void register(String username, String password);
    boolean isRegistered();
    void login(String username, String password);
    void perkenalkan();
}
