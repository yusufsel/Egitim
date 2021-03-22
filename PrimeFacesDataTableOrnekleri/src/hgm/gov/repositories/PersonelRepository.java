package hgm.gov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hgm.gov.entities.Personel;

public interface PersonelRepository extends JpaRepository<Personel, Integer> {
	public Personel findByTcNo(String tcNo);
}
