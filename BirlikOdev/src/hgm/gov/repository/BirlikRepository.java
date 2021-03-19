package hgm.gov.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hgm.gov.entities.Birlik;

public interface BirlikRepository extends JpaRepository<Birlik, Integer> {
	@Query(value = "SELECT birlik_id, count(*) sayi FROM personel group by birlik_id order by 1", nativeQuery = true)
	public List<Object[]> getBirlikCalisanSayilari();
}
