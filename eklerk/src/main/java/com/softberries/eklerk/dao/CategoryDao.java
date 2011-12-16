package com.softberries.eklerk.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;
import org.jboss.seam.solder.logging.Category;

import com.softberries.eklerk.data.StoreRepository;
import com.softberries.eklerk.model.ProductCategory;

@Stateless
public class CategoryDao {

	@Inject
    @Category("eklerk")
    private Logger log;
    
    @Inject
    @StoreRepository
    private EntityManager em;
    
    public List<ProductCategory> findMainCategories(){
    	Query query = em.createQuery("SELECT cat FROM ProductCategory cat WHERE cat.main = true");
		return query.getResultList();
    }
    public void updateCategory(ProductCategory cat){
    	log.debug("updating category: " + cat);
    	em.merge(cat);
		em.flush();
    }
    public void addCategory(ProductCategory cat){
    	log.debug("adding category: " + cat);
    	em.persist(cat);
    }
    public void deleteCategory(ProductCategory cat){
    	log.debug("removing category: " + cat);
    	em.remove(cat);
    }
    
}
