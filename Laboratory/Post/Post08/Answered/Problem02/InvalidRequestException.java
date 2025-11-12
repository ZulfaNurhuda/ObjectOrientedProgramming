/**
 * Exception unchecked untuk request tidak valid dari sisi klien,
 */
public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String m){ 
        super(m);
    }
}
