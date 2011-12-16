package com.softberries.eklerk.test;

import static org.junit.Assert.*;

import com.softberries.eklerk.controller.UserRegistration;
import com.softberries.eklerk.data.UserRepository;
import com.softberries.eklerk.data.UserRepositoryProducer;
import com.softberries.eklerk.model.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class CategoryTest {

    @Deployment
    public static Archive<?> createArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(User.class, UserRegistration.class, UserRepository.class, UserRepositoryProducer.class)
                        // addAsManifestResource is incorrectly targeting /META-INF
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println("testing arquilian");
	}

}
