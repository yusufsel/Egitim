package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {
	private static Properties prop = new Properties();

	private Util() {
	}

	public static void init() {
		InputStream is = Util.class.getResourceAsStream("/db.properties");
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getDBProp(String key) {
		return prop.getProperty(key);
	}
}
