public class DuplicateItemException extends OrderingSystemException {
	public DuplicateItemException(String message) {
		super(message, "ERR_DUPLICATE_ITEM");
	}
}
