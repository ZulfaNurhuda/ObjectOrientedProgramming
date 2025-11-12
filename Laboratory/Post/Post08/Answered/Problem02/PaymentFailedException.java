/**
 * Exception checked untuk kegagalan pembayaran.
 * Gunakan cause untuk menyimpan IOException dari gateway (CHAINED EXCEPTION).
 */
public class PaymentFailedException extends Exception {
    public PaymentFailedException(String m, Throwable cause){ 
        super(m, cause);
    }
}
