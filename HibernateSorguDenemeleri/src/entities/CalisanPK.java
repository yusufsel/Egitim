package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class CalisanPK implements Serializable {
	private static final long serialVersionUID = -3304326323029766784L;

	@Column(name = "ise_giris_yili")
	private int iseGirisYili;

	@Column(name = "sira_no")
	private int siraNo;
}
