package util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

public class Util {
	private static final ThreadLocal<List<Locale>> locales = new ThreadLocal<List<Locale>>();

	private Util() {
	}

	public static void init() {
	}

	public static String getDBProp(String key) {
		return ResourceBundle.getBundle("db").getString(key);
	}

	public static String getMessage(String key) {
		return ResourceBundle.getBundle("mesaj", Util.locales.get().get(0)).getString(key);
	}

	public static void setLocales(Enumeration<Locale> locales) {
		Util.locales.set(new ArrayList<Locale>());

		while (locales.hasMoreElements()) {
			Locale locale = locales.nextElement();
			Util.locales.get().add(locale);
		}
	}

	public static void main(String[] args) {
		List<String> liste = new ArrayList<String>();
		liste.add("tr");
		ResourceBundle.Control control = ResourceBundle.Control.getControl(Control.FORMAT_DEFAULT);
		ResourceBundle rb = ResourceBundle.getBundle("mesaj", control);
		System.out.println(rb.getString("okunamadi.tablo"));
	}
}
