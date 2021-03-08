package exceptions.business;

import java.text.MessageFormat;

import util.Util;

public class BusinessException extends Exception {
	private static final long serialVersionUID = -4077483536377541835L;
	private Object[] mesajParametreleri;

	public BusinessException(String message, Object... parametreler) {
		super(message);
		this.mesajParametreleri = parametreler;
	}

	public BusinessException(String message, Throwable cause, Object... parametreler) {
		super(message, cause);
		this.mesajParametreleri = parametreler;
	}

	@Override
	public String getMessage() {
		String mesaj = Util.getMessage(super.getMessage());
		if (mesajParametreleri != null) {
			mesaj = MessageFormat.format(mesaj, mesajParametreleri);
		}
		return mesaj;
	}

}
