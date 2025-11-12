public class InsufficientBalanceException extends OrderingSystemException {
	public InsufficientBalanceException(String message) {
		super(message, "ERR_INSUFFICIENT_BALANCE");
	}
}
