package com.softberries.eklerk.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;
import org.jboss.seam.solder.logging.Category;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.softberries.eklerk.dao.CategoryDao;
import com.softberries.eklerk.model.ProductCategory;

@Model
@Named("categories")
public class CategoryController {

    @Inject
    @Category("eklerk")
    private Logger log;
    
    @Inject
    private CategoryDao cDao;
    
    private ProductCategory newCategory;
    
    private ProductCategory currentCategory;
    
    private List<ProductCategory> categories;
    
    private TreeNode root;
    
    @PostConstruct
    public void init(){
    	this.categories = cDao.findMainCategories();
    }
    
    public void prepareCategoryTree(TreeNode node){
    	if(node == null){
    		root = new DefaultTreeNode("Kategorie", null);
    	}
    	for(ProductCategory pc : this.categories){
    		if(pc.getSubCategories() != null && pc.getSubCategories().size() > 0){
    			
    		}
    	}
		TreeNode node0 = new DefaultTreeNode("Node 0", root);
    }
    
    public void moveUp(){
    	log.debug("moving category: " + currentCategory + ", up");
    }
    public void moveDown(){
    	log.debug("moving category: " + currentCategory + ", down");
    }
    public void addCategory(){
    	log.debug("saving category: " + currentCategory);
    }
    public void deleteCategory(){
    	log.debug("deleting category: " + currentCategory);
    }

	public ProductCategory getNewCategory() {
		return newCategory;
	}

	public void setNewCategory(ProductCategory newCategory) {
		this.newCategory = newCategory;
	}

	public ProductCategory getCurrentCategory() {
		return currentCategory;
	}

	public void setCurrentCategory(ProductCategory currentCategory) {
		this.currentCategory = currentCategory;
	}

	public List<ProductCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<ProductCategory> categories) {
		this.categories = categories;
	}
    
}
