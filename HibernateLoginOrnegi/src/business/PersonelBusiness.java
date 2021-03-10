package business;

import dao.PersonelDAO;
import entities.Personel;
import util.PasswordAuthentication;

public class PersonelBusiness {

	public void personelYarat(Personel personel) {
		personel.setSifre(new PasswordAuthentication().hash(personel.getSifre().toCharArray()));
		new PersonelDAO().personelYarat(personel);
	}
}
