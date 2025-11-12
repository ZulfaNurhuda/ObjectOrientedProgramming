import java.io.IOException;

/**
 * Abstraksi gateway pembayaran eksternal.
 * Metode charge dapat melempar IOException untuk kegagalan jaringan/IO.
 */
public interface PaymentGateway {
    /**
     * Melakukan charge ke kartu.
     * @param cardNumber nomor kartu
     * @param amountCents jumlah dalam satuan sen (cent)
     * @throws IOException jika terjadi kegagalan jaringan/IO
     */
    void charge(String cardNumber, int amountCents) throws IOException;
}