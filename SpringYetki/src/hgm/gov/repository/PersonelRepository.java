package hgm.gov.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hgm.gov.entities.Personel;

public interface PersonelRepository extends JpaRepository<Personel, Integer> {
	public Personel findByTcno(int tcNo);
}
