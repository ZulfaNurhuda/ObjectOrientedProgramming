/* TODO : Lengkapi custom exception InvalidAmountException
   Exception ini digunakan saat nominal transaksi tidak valid (misalnya negatif).
   Turunkan dari Exception (checked exception).
   Buat konstruktor dengan parameter pesan (String message).
   Contoh pesan: "Nominal transaksi tidak boleh negatif." */
public class InvalidAmountException extends Exception {
    // Type your code
    public InvalidAmountException(String message) {
        super(message);
    }
}
