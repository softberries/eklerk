package com.softberries.eklerk.data;

import com.softberries.eklerk.model.User;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@RequestScoped
public class UserListProducer {
    @Inject
    @UserRepository
    private EntityManager em;

    private List<User> users;

    // @Named provides access the return value via the EL variable name "member" in the UI (e.g., Facelets or JSP view)
    @Produces
    @Named
    public List<User> getUsers() {
        return users;
    }

    public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final User member) {
        retrieveAllUsersOrderedByName();
    }

    @PostConstruct
    public void retrieveAllUsersOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> user = criteria.from(User.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new feature in JPA 2.0
        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
        criteria.select(user).orderBy(cb.asc(user.get("name")));
        users = em.createQuery(criteria).getResultList();
    }
}
