package fr.epsi;

import fr.epsi.Biblio.Client;
import fr.epsi.Biblio.Emprunt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        System.out.println("Connexion à la base de données réussie !");

        em.getTransaction().begin();

        Client client = em.find(Client.class, 1);

        em.getTransaction().commit();

        if (client != null) {
            System.out.println("Client trouvé : " + client);
            System.out.println("Emprunts associés :");
            for (Emprunt emprunt : client.getEmprunts()) {
                System.out.println(emprunt);
            }
        } else {
            System.out.println("Aucun client trouvé avec cet ID.");
        }

        em.close();
        emf.close();
    }
}
