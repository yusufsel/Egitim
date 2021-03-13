package test;

import java.util.List;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;

import entities.Birlik;
import entities.Personel;
import entities.PersonelAdres;

public class Test5 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		Properties properties = new Properties();
		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.PASS, "harita");
		properties.put(Environment.USER, "harita_user");
		properties.put(Environment.URL, "jdbc:mysql://localhost:3306/harita?serverTimezone=UTC");
		properties.put(Environment.SHOW_SQL, "true");

		configuration.setProperties(properties);

		configuration.addAnnotatedClass(Personel.class);
		configuration.addAnnotatedClass(PersonelAdres.class);
		configuration.addAnnotatedClass(Birlik.class);

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Query<String> query = session.createQuery("select adi from Personel p", String.class);
		query.setFirstResult(1);
		query.setMaxResults(2);
		List<String> sonuc = query.list();
		sonuc.forEach(s -> System.out.println(s));
	}

}
