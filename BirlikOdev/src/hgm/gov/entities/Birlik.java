package hgm.gov.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Entity
@Data
public class Birlik {
	@Id
	private int id;
	private String adi;
	private int mevcut;
	private String sehir;
}
