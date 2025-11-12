public class OrderingSystemException extends Exception {
	private String errorCode;
	private String timestamp;

	public OrderingSystemException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
		this.timestamp = java.time.LocalDateTime.now().toString();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return "[" + errorCode + "] " + getMessage();
	}

	public String getDetailedMessage() {
		return "[" + errorCode + "] " + getMessage() + " (Time: " + timestamp + ")";
	}
}
