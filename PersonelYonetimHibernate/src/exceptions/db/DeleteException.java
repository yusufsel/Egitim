package exceptions.db;

public class DeleteException extends CRUDException {
	private static final long serialVersionUID = 6890769793112202780L;

	public DeleteException(String message, Throwable cause) {
		super(message, cause);
	}

	public DeleteException(String message) {
		super(message);
	}

}
