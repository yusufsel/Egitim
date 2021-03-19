package hgm.gov.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hgm.gov.dao.PersonelDAO;
import hgm.gov.dao.PersonelYetkiDAO;
import hgm.gov.entities.Personel;
import hgm.gov.entities.PersonelYetki;
import hgm.gov.util.Util;

@Service
public class PersonelService {
	@Autowired
	private PersonelDAO personelDAO;
	@Autowired
	private PersonelYetkiDAO personelYetkiDAO;

	public boolean girisYap(String tcNo, String sifre) {
		Personel personel = personelDAO.getPersonel(tcNo);
		if (personel != null) {
			if (Util.getPasswordAuthentication().authenticate(sifre.toCharArray(), personel.getSifre())) {
				return true;
			}
		}
		return false;
	}

	public List<PersonelYetki> getPersonelYetkileri(String tcNo) {
		return personelYetkiDAO.getPersonelYetkileri(tcNo);
	}

	public List<Personel> getPersoneller() {
		return personelDAO.getPersoneller();
	}
}
