package hgm.gov.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hgm.gov.entities.PersonelYetki;
import hgm.gov.repository.PersonelYetkiRepository;

@Component
public class PersonelYetkiDAO {
	@Autowired
	private PersonelYetkiRepository personelYetkiRepository;

	public List<PersonelYetki> getPersonelYetkileri(String tcNo) {
		return personelYetkiRepository.findByPersonelTcno(tcNo);
	}
}
