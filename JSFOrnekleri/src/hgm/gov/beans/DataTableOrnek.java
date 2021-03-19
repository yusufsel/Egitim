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
			new Kitap("Zaman�n K�sa Tarihi", "Stephen Hawking", "�izgi"),
			new Kitap("Aylak Adam", "Yusuf At�lgan", "Yap� Kredi"),
			new Kitap("Metastaz", "Bar�� Pehlivan", "K�rm�z� Kedi"),
			new Kitap("Satran�", "Stephen Zweig", "Can")
			);
	//@formatter:on
}
