package com.softberries.eklerk.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile ListAttribute<Product, ProductPhoto> photos;
	public static volatile SingularAttribute<Product, Long> id;
	public static volatile SingularAttribute<Product, String> priceNet;
	public static volatile SingularAttribute<Product, String> tax;
	public static volatile SingularAttribute<Product, String> description;
	public static volatile SingularAttribute<Product, String> name;
	public static volatile SingularAttribute<Product, Date> dateAdded;
	public static volatile ListAttribute<Product, ProductAttribute> attributes;
	public static volatile SingularAttribute<Product, Boolean> deleted;
	public static volatile SingularAttribute<Product, String> priceGross;

}

