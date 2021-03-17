package hgm.gov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hgm.gov.dao.PersonelDAO;
import hgm.gov.entities.Personel;

@Service
public class PersonelService {
	@Autowired
	private PersonelDAO personelDAO;

	public boolean girisYap(int tcNo, String sifre) {
		Personel personel = personelDAO.getPersonel(tcNo);
		if (personel != null) {
			if (personel.getSifre().equals(sifre)) {
				return true;
			}
		}
		return false;
	}
}
