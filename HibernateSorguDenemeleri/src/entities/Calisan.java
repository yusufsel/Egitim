package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Calisan implements Serializable {
	private static final long serialVersionUID = -998442323496274878L;

	@EmbeddedId
	private CalisanPK id;

	@Column(name = "adi")
	private String isim;
}
