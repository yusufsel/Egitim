package hgm.gov.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
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
