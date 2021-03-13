package exceptions.db;

public class CreateException extends CRUDException {
	private static final long serialVersionUID = 6585433528791573917L;

	public CreateException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreateException(String message) {
		super(message);
	}

}
