public class OrderLimitExceededException extends OrderingSystemException {
	public OrderLimitExceededException(String message) {
		super(message, "ERR_ORDER_LIMIT_EXCEEDED");
	}
}
