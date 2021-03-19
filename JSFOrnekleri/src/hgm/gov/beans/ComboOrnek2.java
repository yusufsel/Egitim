package hgm.gov.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import lombok.Data;

@Data
@ManagedBean
@SessionScoped
public class ComboOrnek2 {
	private String comboDegeri;
	private List<SelectItem> degerler = new ArrayList<SelectItem>();

	public ComboOrnek2() {
		degerler.add(new SelectItem("1", "Seçenek 1"));
		degerler.add(new SelectItem("2", "Seçenek 2"));
		degerler.add(new SelectItem("3", "Seçenek 3"));
		degerler.add(new SelectItem("4", "Seçenek 4"));
		degerler.add(new SelectItem("5", "Seçenek 5"));
		System.out.println("ComboOrnek2 instance'i oluþturuldu");
	}

	public void oku() {
	}

	public void sil() {
		comboDegeri = null;
	}

	public void ekle() {
		String sira = String.valueOf(degerler.size() + 1);
		SelectItem item = new SelectItem(sira, "Seçenek " + sira);
		degerler.add(item);
	}
}
