public class InvalidPriceException extends OrderingSystemException {
	public InvalidPriceException(String message) {
		super(message, "ERR_INVALID_PRICE");
	}
}
