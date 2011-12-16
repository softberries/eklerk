package com.softberries.eklerk.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Category.class)
public abstract class Category_ {

	public static volatile SingularAttribute<Category, Long> id;
	public static volatile ListAttribute<Category, Category> subCategories;
	public static volatile SingularAttribute<Category, Category> parentCategory;
	public static volatile SingularAttribute<Category, String> name;
	public static volatile SingularAttribute<Category, String> fullName;
	public static volatile SingularAttribute<Category, Boolean> main;

}

