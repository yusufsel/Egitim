package exceptions.db;

public class CRUDException extends Exception {
	private static final long serialVersionUID = -2342801453951788299L;

	public CRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	public CRUDException(String message) {
		super(message);
	}

}
