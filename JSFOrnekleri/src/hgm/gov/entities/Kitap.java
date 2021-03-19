package hgm.gov.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kitap {
	private String adi;
	private String yazar;
	private String yayinEvi;
}
