package hgm.gov.service;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hgm.gov.dao.BirlikDAO;

@Service
public class BirlikService {
	@Autowired
	private BirlikDAO birlikDAO;

	public List<SimpleEntry<Integer, Integer>> getBirlikSayilari() {
		return birlikDAO.getBirlikSayilari();
	}
}
