package exceptions.db;

public class UpdateException extends CRUDException {
	private static final long serialVersionUID = 32817642178L;

	public UpdateException(String message, Throwable cause) {
		super(message, cause);
	}

	public UpdateException(String message) {
		super(message);
	}

}
