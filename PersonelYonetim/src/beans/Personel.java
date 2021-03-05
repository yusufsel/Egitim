package beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personel {
	private int id;
	private String tcNo;
	private String adi;
	private String soyadi;
	private String sifre;
}
