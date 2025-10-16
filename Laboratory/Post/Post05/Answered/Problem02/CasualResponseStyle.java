public class CasualResponseStyle implements ResponseStyle {
    // TODO:
    // Kelas ini harus mengimplementasikan interface ResponseStyle

    // TODO:
    // Kelas ini harus method format dari DeliveryChannel dengan ketentuan:
    // 1. Lakukan return: "Hey! <response>""
    public String format(String baseResponse) {
        String message = "";
        if (baseResponse != null) {
            message = "Hey! " + baseResponse;
        }
        return message;
    }
}
