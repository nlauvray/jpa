package fr.epsi;

import fr.epsi.Biblio.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        System.out.println("Connexion à la base de données réussie !");

        em.getTransaction().begin();

        Livre livre = em.find(Livre.class, 1);

        em.getTransaction().commit();

        if (livre != null) {
            System.out.println(livre.getId());
        }

        em.close();
        emf.close();
    }
}
