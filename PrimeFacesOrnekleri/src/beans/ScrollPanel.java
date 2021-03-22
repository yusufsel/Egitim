package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import lombok.Data;

@Data
@ManagedBean
public class ScrollPanel {
	private List<Integer> sayilar = new ArrayList<Integer>();

	public ScrollPanel() {
		for (int i = 0; i < 1000; i++) {
			sayilar.add(i);
		}
	}
}
