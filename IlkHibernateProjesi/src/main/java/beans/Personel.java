package beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Personel")
public class Personel {
	@Id
	private int id;
	@Column(name = "tcno")
	private String tcKimlikNo;
	private String adi;
	private String soyadi;
	private String sifre;
	@OneToMany(mappedBy = "personel")
	private List<PersonelAdres> personelAdresler;
}
