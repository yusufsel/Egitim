package hgm.gov.dao;

import java.math.BigInteger;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hgm.gov.repository.BirlikRepository;

@Component
public class BirlikDAO {
	@Autowired
	private BirlikRepository birlikRepository;

	public List<SimpleEntry<Integer, Integer>> getBirlikSayilari() {
		List<Object[]> sonuc = birlikRepository.getBirlikCalisanSayilari();
		List<SimpleEntry<Integer, Integer>> birlikSayilariListesi = new ArrayList<SimpleEntry<Integer, Integer>>();
		for (Object[] kayit : sonuc) {
			Integer birlikId = (Integer) kayit[0];
			Integer birlikCalisanSayisi = ((BigInteger) kayit[1]).intValue();
			SimpleEntry<Integer, Integer> deger = new SimpleEntry<Integer, Integer>(birlikId, birlikCalisanSayisi);
			birlikSayilariListesi.add(deger);
		}
		return birlikSayilariListesi;
	}
}
