package business;

import java.util.List;

import beans.Personel;
import db.PersonelDB;
import exceptions.business.BusinessException;
import exceptions.db.CRUDException;
import util.Sabitler;

public class PersonelBusiness {
	public List<Personel> getPersoneller() throws BusinessException {
		try {
			return new PersonelDB().getPersonelListesi();
		} catch (CRUDException e) {
			throw new BusinessException(Sabitler.HATA_PERSONEL_OKUNAMADI, e);
		}
	}
}
