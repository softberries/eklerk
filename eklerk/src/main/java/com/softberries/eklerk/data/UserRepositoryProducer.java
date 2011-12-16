package com.softberries.eklerk.data;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This class uses CDI to produce EntityManager instances qualified that are qualified as &#064;MemberRepository.
 * 
 * <p>
 * Example injection on a managed bean field:
 * </p>
 * 
 * <pre>
 * &#064;Inject
 * &#064;MemberRepository
 * private EntityManager memberRepository;
 * </pre>
 */
public class UserRepositoryProducer {
    // use @SuppressWarnings to tell IDE to ignore warnings about field not being referenced directly
    @SuppressWarnings("unused")
    @Produces
    @StoreRepository
    @PersistenceContext
    private EntityManager em;
}
