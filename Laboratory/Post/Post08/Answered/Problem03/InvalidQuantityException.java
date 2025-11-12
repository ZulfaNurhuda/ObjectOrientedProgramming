public class InvalidQuantityException extends OrderingSystemException {
	public InvalidQuantityException(String message) {
		super(message, "ERR_INVALID_QUANTITY");
	}
}
