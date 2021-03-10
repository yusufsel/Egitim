package business;

import dao.PersonelDAO;
import entities.Personel;
import util.PasswordAuthentication;

public class LoginBusiness {
	public boolean login(String tcNo, String password) {
		Personel personel = new PersonelDAO().getPersonel(tcNo);
		if (personel != null) {
			String dbSifre = personel.getSifre();
			if (dbSifre != null) {
				return new PasswordAuthentication().authenticate(password.toCharArray(), dbSifre);
			}
		}
		return false;
	}
}
