package exceptions.db;

public class ReadException extends CRUDException {
	private static final long serialVersionUID = 974326212874640482L;

	public ReadException(String message, Throwable cause) {
		super(message, cause);
	}

	public ReadException(String message) {
		super(message);
	}

}
