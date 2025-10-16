public class ApiDeliveryChannel implements DeliveryChannel {
    // TODO:
    // Kelas ini harus mengimplementasikan interface Delivery channel

    // TODO:
    // Kelas ini harus memiliki sebuah attribute token dengan tipe String
    // Inisialisasi token dilakukan dalam konstruktor kelas, apabila token yang
    // di-passing dalam parameter konstruktor kelas adalah null, maka beri nilai
    // default yaitu: "BLANK"
    private String token;
    
    public ApiDeliveryChannel(String token) {
        this.token = (token == null) ? "BLANK" : token;
    }

    // TODO:
    // Kelas ini harus method deliver dari DeliveryChannel dengan ketentuan:
    // 1. Ketika responsenya adalah null maka return string kosong ("")
    // 2. Ketika responsenya valid, return: "[API token=<token>] <chatbot name>: <response>"
    public String deliver(String response, Chatbot chatbot) {
        String message = "";
        if (response != null) {
            message = "[API token=" + token + "] " + chatbot.getName() + ": " + response;
        }
        return message;
    }
}
