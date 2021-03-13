package business;

import java.util.List;

import dao.PersonelDAO;
import entities.Personel;

public class PersonelBusiness {
	public List<Personel> getPersonelListesi() {
		return new PersonelDAO().getPersoneller();
	}
}
