package business;

import java.util.List;

import dao.IsimlerDAO;
import entities.Isimler;

public class IsimlerBusiness {
	public List<Isimler> getIsimler(int baslangicKayitSayisi) {
		return new IsimlerDAO().getIsimler(baslangicKayitSayisi);
	}
}
