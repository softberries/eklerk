package com.softberries.eklerk.data;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TransactionRequiredException;
import javax.transaction.UserTransaction;

import com.softberries.eklerk.model.ProductAttribute;
import com.softberries.eklerk.model.ProductCategory;
import org.jboss.logging.Logger;

import com.softberries.eklerk.model.User;
import org.jboss.seam.solder.logging.Category;

/**
 * Import seed data into the database on application startup.
 * 
 * <p>
 * Observes the context initialized event and loads seed data into the database using JPA.
 * </p>
 * 
 * <p>
 * As an alternative, you can perform the data loading by observing the context initialized event of a ServletContextListener
 * </p>
 * 
 * @author Dan Allen
 */
@Startup
@Singleton
public class SeedDataImporter {
    @Inject
    @Category("eklerk")
    private Logger log;

    @Inject
    @UserRepository
    private EntityManager em;

    @Inject
    private UserTransaction tx;

    @PostConstruct
    public void importData() {
        importUsers();
        importCategories();
    }

    private void importCategories() {
        ProductCategory main = new ProductCategory(null, "Główna", true);
        ProductCategory sub1 = new ProductCategory(main, "Podkategoria 1", false);
        ProductCategory sub2 = new ProductCategory(main, "Podkategoria 2", false);
        ProductCategory sub11 = new ProductCategory(sub1, "Podkategoria 1.1", false);
        em.persist(main);
        em.persist(sub1);
        em.persist(sub2);
        em.persist(sub11);
    }

    private void importAttributes(){
    	ProductAttribute pa = new ProductAttribute();
    }
    private void importUsers() {
        User member1 = new User();
        member1.setName("John Smith");
        member1.setEmail("john.smith@mailinator.com");
        member1.setPhoneNumber("2125551212");
        try {
            try {
                em.persist(member1);
            } catch (TransactionRequiredException e) {
                // manual transaction control required in @PostConstruct method
                // only use if enforced by JPA provider (due to bug in GlassFish)
                tx.begin();
                em.persist(member1);
                tx.commit();
            }
            log.info("Successfully imported seed data.");
        } catch (Exception e) {
            log.warn("Seed data import failed.", e);
        }
    }
}
