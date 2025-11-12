public class CustomerNotFoundException extends OrderingSystemException {
	public CustomerNotFoundException(String message) {
		super(message, "ERR_CUSTOMER_NOT_FOUND");
	}
}
