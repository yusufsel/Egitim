package hgm.gov.util;

import java.util.List;

import javax.servlet.http.HttpSession;

import hgm.gov.entities.PersonelYetki;

public class Util {
	private static PasswordAuthentication passwordAuthentication = new PasswordAuthentication();

	// instance yaratilmasini engeller
	private Util() {
	}

	public static PasswordAuthentication getPasswordAuthentication() {
		return passwordAuthentication;
	}

	@SuppressWarnings("unchecked")
	public static boolean yetkiVarmi(HttpSession session, int yetkiId) {
		List<PersonelYetki> personelYetkiler = (List<PersonelYetki>) session.getAttribute("yetkiler");
		if (personelYetkiler != null) {
			for (PersonelYetki personelYetki : personelYetkiler) {
				if (personelYetki.getYetki().getId() == yetkiId) {
					return true;
				}
			}
		}
		return false;
	}
}
