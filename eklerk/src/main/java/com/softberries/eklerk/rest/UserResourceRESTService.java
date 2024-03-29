package com.softberries.eklerk.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.softberries.eklerk.data.StoreRepository;
import com.softberries.eklerk.model.User;

/**
 * JAX-RS Example
 * 
 * This class produces a RESTful service to read the contents of the members table.
 */
@Path("/users")
@RequestScoped
public class UserResourceRESTService {
    @Inject
    @StoreRepository
    private EntityManager em;

    @GET
    public List<User> listAllUsers() {
        // Use @SupressWarnings to force IDE to ignore warnings about "genericizing" the results of this query
        @SuppressWarnings("unchecked")
        // We recommend centralizing inline queries such as this one into @NamedQuery annotations on the @Entity class
        // as described in the named query blueprint: https://blueprints.dev.java.net/bpcatalog/ee5/persistence/namedquery.html
        final List<User> results = em.createQuery("select m from User m order by m.name").getResultList();
        return results;
    }

    @GET
    @Path("/{id:[1-9][0-9]*}")
    public User lookupUserById(@PathParam("id") long id) {
        return em.find(User.class, id);
    }
}
