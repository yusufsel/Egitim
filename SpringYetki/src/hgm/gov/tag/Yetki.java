package hgm.gov.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import hgm.gov.util.Util;

public class Yetki extends TagSupport {
	private static final long serialVersionUID = -7843534466162458860L;
	private String yetkiId;

	@Override
	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession();

		if (Util.yetkiVarmi(session, getKontrolId())) {
			return EVAL_BODY_INCLUDE;
		}
		return SKIP_BODY;
	}

	private int getKontrolId() {
		switch (yetkiId) {
		case "YETKI_PERSONEL_LISTELEME":
			return 1;
		case "YETKI_PERSONEL_YARATMA":
			return 2;
		default:
			return 0;
		}
	}

	public String getYetkiId() {
		return yetkiId;
	}

	public void setYetkiId(String yetkiId) {
		this.yetkiId = yetkiId;
	}

}