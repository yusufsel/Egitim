package hgm.gov.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hgm.gov.dao.PersonelDAO;
import hgm.gov.entities.Personel;

@Service
public class PersonelBusiness {
	@Autowired
	private PersonelDAO personelDAO;

	public List<Personel> getPersoneller() {
		return personelDAO.getPersoneller();
	}
}
