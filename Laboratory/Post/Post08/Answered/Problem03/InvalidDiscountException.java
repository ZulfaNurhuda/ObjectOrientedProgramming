public class InvalidDiscountException extends OrderingSystemException {
	public InvalidDiscountException(String message) {
		super(message, "ERR_INVALID_DISCOUNT");
	}
}
