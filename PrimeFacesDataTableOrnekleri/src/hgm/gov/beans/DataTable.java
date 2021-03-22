package hgm.gov.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import hgm.gov.entities.Personel;
import hgm.gov.service.PersonelService;
import lombok.Data;

@Data
@Named
@ManagedBean
public class DataTable {
	@Inject
	private PersonelService personelService;

	public List<Personel> getPersoneller() {
		List<Personel> liste = personelService.getPersoneller();
		return liste;
	}
}
