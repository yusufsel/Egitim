package hgm.gov.util;

public class Util {
	private static PasswordAuthentication passwordAuthentication = new PasswordAuthentication();

	// instance yaratilmasini engeller
	private Util() {
	}

	public static PasswordAuthentication getPasswordAuthentication() {
		return passwordAuthentication;
	}

	public static void main(String[] args) {
		System.out.println(passwordAuthentication.hash("123".toCharArray()));
	}
}
