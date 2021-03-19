package hgm.gov.beans;

import javax.faces.bean.ManagedBean;

import lombok.Data;

@Data
@ManagedBean
public class ComboOrnek {
	private String comboDegeri;

	public void oku() {
	}

	public void sil() {
		comboDegeri = null;
	}
}
