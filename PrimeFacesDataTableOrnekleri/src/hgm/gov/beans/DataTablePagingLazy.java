package hgm.gov.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import hgm.gov.model.IsimlerLazyDataModel;
import hgm.gov.service.IsimlerService;

@Named
@ManagedBean
@SessionScoped
public class DataTablePagingLazy {
	@Inject
	private IsimlerService isimlerService;
	private IsimlerLazyDataModel isimlerLazyDataModel;

	public IsimlerLazyDataModel getListe() {
		if (isimlerLazyDataModel == null) {
			isimlerLazyDataModel = new IsimlerLazyDataModel(isimlerService);
		}
		return isimlerLazyDataModel;
	}

}
