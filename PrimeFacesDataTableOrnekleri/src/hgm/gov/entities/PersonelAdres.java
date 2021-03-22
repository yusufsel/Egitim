package hgm.gov.entities;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Named
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "personel_adres")
public class PersonelAdres {
	@Id
	private int id;
	@ManyToOne
	private Personel personel;
	private String adres;
}
