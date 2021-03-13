package beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Personel {
	@Id
	private int id;
	private String tcNo;
	private String adi;
	private String soyadi;
	private String sifre;
	@OneToMany(mappedBy = "personel")
	private Set<PersonelAdres> adresler;

	private byte[] resim;
}
