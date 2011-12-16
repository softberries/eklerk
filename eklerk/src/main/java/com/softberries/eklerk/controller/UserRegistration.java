package com.softberries.eklerk.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import org.jboss.logging.Logger;
import org.jboss.seam.solder.logging.Category;

import com.softberries.eklerk.data.UserRepository;
import com.softberries.eklerk.model.User;

// Adding the @Stateful annotation eliminates need for manual transaction demarcation
// @javax.ejb.Stateful
// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an EL name
// Read more about the @Model stereotype in this FAQ: http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation
@Model
public class UserRegistration {
    @Inject
    @Category("eklerk")
    private Logger log;

    @Inject
    @UserRepository
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    @Inject
    private Event<User> memberEventSrc;

    private User newUser;

    @Produces
    @Named
    public User getNewUser() {
        return newUser;
    }

    public void register() throws Exception {
        log.info("Registering " + newUser.getName());
        // UserTransaction only needed when bean is not an EJB
        utx.begin();
        em.joinTransaction();
        em.persist(newUser);
        utx.commit();
        memberEventSrc.fire(newUser);
        initNewUser();
    }
    
    public String login(){
    	
    	return "index";
    }

    @PostConstruct
    public void initNewUser() {
        newUser = new User();
    }
}
