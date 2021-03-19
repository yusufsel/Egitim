package hgm.gov.beans;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import hgm.gov.entities.Kitap;
import lombok.Data;

@Data
@ManagedBean
@SessionScoped
public class DataTableOrnek {
	//@formatter:off
	private List<Kitap> kitaplar = Arrays.asList(
			new Kitap("Zamanýn Kýsa Tarihi", "Stephen Hawking", "Çizgi"),
			new Kitap("Aylak Adam", "Yusuf Atýlgan", "Yapý Kredi"),
			new Kitap("Metastaz", "Barýþ Pehlivan", "Kýrmýzý Kedi"),
			new Kitap("Satranç", "Stephen Zweig", "Can")
			);
	//@formatter:on
}
