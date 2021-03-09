package beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "personel_adres")
public class PersonelAdres {
	@Id
	private int id;
	@ManyToOne()
	@ToString.Exclude
	private Personel personel;
	private String adres;
}
