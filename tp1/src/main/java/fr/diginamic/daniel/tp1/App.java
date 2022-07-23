package fr.diginamic.daniel.tp1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.daniel.tp1.bo.Client;
import fr.diginamic.daniel.tp1.bo.Emprunt;
import fr.diginamic.daniel.tp1.bo.Livre;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-pu");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Livre liv = em.find(Livre.class, 2);
		if (liv != null) {
			System.out.println(liv);
		}

		Livre liv2 = em.find(Livre.class, 5);
		if (liv2 != null) {
			liv2.setTitre("Du plaisir dans la cuisine");

		}

		// Livre liv1 = new Livre();
		// liv1.setId(6);
		// liv1.setTitre("La planete des singes");
		// liv1.setAuteur("Emile zola");
		// em.persist(liv1);

		Emprunt emprunt = em.find(Emprunt.class, 1);
		if (emprunt != null) {
			System.out.println(emprunt.getLivres());

			Client client = em.find(Client.class, 1);
			if (client != null) {
				System.out.println(client.getEmprunts());

			}

			TypedQuery<Livre> queryL = em.createQuery("select l from Livre l where l.titre='Germinal'", Livre.class);
			Livre l = queryL.getResultList().get(0);

			System.out.println(l);

			TypedQuery<Livre> queryA = em.createQuery("select a from Livre a where a.auteur='Jules Verne'",
					Livre.class);
			Livre a = queryA.getResultList().get(0);
			System.out.println(a);
			// System.out.println(em);

			Livre li = em.find(Livre.class, 3);
			if (li != null) {
				em.remove(li);

			}

			TypedQuery<Livre> queryZ = em.createQuery("from Livre", Livre.class);
			List<Livre> all = queryZ.getResultList();

			for (Livre current : all) {
				System.out.println(current.getAuteur() + " " + current.getTitre());
			}

			em.getTransaction().commit();
			em.close();
			emf.close();

			System.out.println(em);
		}

	}
}
