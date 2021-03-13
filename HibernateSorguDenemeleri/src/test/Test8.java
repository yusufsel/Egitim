package test;

import java.util.Properties;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import entities.Birlik;
import entities.Calisan;
import entities.Personel;
import entities.PersonelAdres;

public class Test8 {

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
		configuration.addAnnotatedClass(Calisan.class);

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Birlik birlik = session.get(Birlik.class, 2);
		System.out.println(birlik);
		Set<Personel> personeller = birlik.getPersoneller();
		for (Personel p : personeller) {
			System.out.println(p);
			Set<PersonelAdres> adresler = p.getPersonelAdres();
			for (PersonelAdres adres : adresler) {
				System.out.println(adres);
			}
		}
	}

}
