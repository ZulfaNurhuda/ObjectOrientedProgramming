/* TODO : Lengkapi custom exception InsufficientBalanceException
   Exception ini digunakan saat saldo akun tidak mencukupi untuk penarikan atau transfer.
   Turunkan dari Exception (checked exception).
   Buat konstruktor dengan parameter pesan (String message).
   Contoh pesan: "Saldo tidak mencukupi untuk melakukan penarikan." */
public class InsufficientBalanceException extends Exception {
    // Type your code
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
