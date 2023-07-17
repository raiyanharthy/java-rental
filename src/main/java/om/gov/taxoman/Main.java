package om.gov.taxoman;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import om.gov.taxoman.entity.Customer;
import om.gov.taxoman.entity.Property;
import om.gov.taxoman.entity.PropertyOwner;
import om.gov.taxoman.entity.Rental;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

//        Property property = new Property();
//        property.setName("Jeep");
//        property.setDayRentalPrice(99.00);
//
//        Property property1 = new Property();
//        property1.setName("BMW");
//        property1.setDayRentalPrice(88.00);
//
//        Customer customer = new Customer();
//        customer.setFullName("Raiyan Dudu");
//        customer.setEmail("raiyan@gmail.com");
//        customer.setPassword("rrr");
//
//        Customer customer1 = new Customer();
//        customer1.setFullName("Manar Dudu");
//        customer1.setEmail("manar@gmail.com");
//        customer1.setPassword("mmm");
//
//        PropertyOwner propertyOwner = new PropertyOwner();
//        propertyOwner.setEmail("raiyan@gmail.com");
//        propertyOwner.setPassword("rrr");
//        propertyOwner.setPhoneNumber("968");
//
//        PropertyOwner propertyOwner1 = new PropertyOwner();
//        propertyOwner1.setEmail("manar@gmail.com");
//        propertyOwner1.setPassword("mmm");
//        propertyOwner1.setPhoneNumber("967");




        EntityManagerFactory emf = Persistence.createEntityManagerFactory("raiyan");
        EntityManager em = emf.createEntityManager();
        em.getTransaction() .begin();

        Customer customer = em.find(Customer.class, 1);
        Property property = em.find(Property.class, 1);

        Rental rental = new Rental();
        rental.setEndDate(LocalDate.now());
        rental.setRentingAmount(77);
        rental.setStartDate(LocalDate.now());
        rental.setCustomer(customer);
        rental.setProperty(property);

        Rental rental1 = new Rental();
        rental1.setEndDate(LocalDate.now());
        rental1.setRentingAmount(66);
        rental1.setStartDate(LocalDate.now());
        rental1.setCustomer(customer);
        rental1.setProperty(property);

//        em.persist(property);
//        em.persist(property1);
//        em.persist(customer);
//        em.persist(customer1);
//        em.persist(propertyOwner);
//        em.persist(propertyOwner1);
        em.persist(rental);
        em.persist(rental1);


        em.getTransaction() .commit();

        em.close();
        emf.close();

    }
}