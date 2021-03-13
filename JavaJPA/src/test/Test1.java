package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Personel;

public class Test1 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JavaJPA");
		EntityManager em = factory.createEntityManager();
		List<Personel> personeller = em.createQuery("from Personel", Personel.class).getResultList();
		personeller.forEach(System.out::println);
	}

}
