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
		degerler.add(new SelectItem("1", "Se�enek 1"));
		degerler.add(new SelectItem("2", "Se�enek 2"));
		degerler.add(new SelectItem("3", "Se�enek 3"));
		degerler.add(new SelectItem("4", "Se�enek 4"));
		degerler.add(new SelectItem("5", "Se�enek 5"));
		System.out.println("ComboOrnek2 instance'i olu�turuldu");
	}

	public void oku() {
	}

	public void sil() {
		comboDegeri = null;
	}

	public void ekle() {
		String sira = String.valueOf(degerler.size() + 1);
		SelectItem item = new SelectItem(sira, "Se�enek " + sira);
		degerler.add(item);
	}
}
