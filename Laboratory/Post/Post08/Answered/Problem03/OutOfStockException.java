public class OutOfStockException extends OrderingSystemException {
	public OutOfStockException(String message) {
		super(message, "ERR_OUT_OF_STOCK");
	}
}
