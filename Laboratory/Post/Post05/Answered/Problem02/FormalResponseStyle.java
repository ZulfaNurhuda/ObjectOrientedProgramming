public class FormalResponseStyle implements ResponseStyle{
    // TODO:
    // Kelas ini harus mengimplementasikan interface ResponseStyle

    // TODO:
    // Kelas ini harus method format dari DeliveryChannel dengan ketentuan:
    // 1. Lakukan return: "Dear user, <response> Sincerely."
    public String format(String baseResponse) {
        String message = "";
        if (baseResponse != null) {
            message = "Dear user, " + baseResponse + " Sincerely.";
        }
        return message;
    }
}
