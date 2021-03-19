package hgm.gov.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hgm.gov.entities.PersonelYetki;

public interface PersonelYetkiRepository extends JpaRepository<PersonelYetki, Integer> {
	public List<PersonelYetki> findByPersonelTcno(String tcNo);
}
