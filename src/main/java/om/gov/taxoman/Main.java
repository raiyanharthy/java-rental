package om.gov.taxoman;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import om.gov.taxoman.entity.Property;

public class Main {
    public static void main(String[] args) {

        Property property = new Property();
        property.setName("Jeep");
        property.setDayRentalPrice(99.00);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("raiyan");
        EntityManager em = emf.createEntityManager();
        em.getTransaction() .begin();

        em.persist(property);

        em.getTransaction() .commit();

        em.close();
        emf.close();

    }
}