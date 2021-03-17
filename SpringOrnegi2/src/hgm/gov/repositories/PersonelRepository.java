package hgm.gov.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hgm.gov.entities.Personel;

@Repository
public interface PersonelRepository extends JpaRepository<Personel, Integer> {
	public List<Personel> findByAdi(String adi);
}
