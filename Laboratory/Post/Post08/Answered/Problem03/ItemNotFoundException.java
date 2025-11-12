public class ItemNotFoundException extends OrderingSystemException {
	public ItemNotFoundException(String message) {
		super(message, "ERR_ITEM_NOT_FOUND");
	}
}
