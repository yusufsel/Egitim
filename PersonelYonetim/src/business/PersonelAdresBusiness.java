package business;

import java.util.List;

import beans.PersonelAdres;
import db.PersonelAdresDB;

public class PersonelAdresBusiness {
	public List<PersonelAdres> getPersonelAdresler(int personelId) {
		return new PersonelAdresDB().getPersonelAdresler(personelId);
	}

	public void personelAdresSil(int personelAdresId) {
		new PersonelAdresDB().personelAdresSil(personelAdresId);
	}

	public void personelAdresEkle(PersonelAdres personelAdres) {
		new PersonelAdresDB().personelAdresEkle(personelAdres);
	}

	public void personelAdresGuncelle(int personelAdresId, PersonelAdres personelAdres) {
		new PersonelAdresDB().personelAdresGuncelle(personelAdresId, personelAdres);
	}

}
