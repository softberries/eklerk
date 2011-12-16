package com.softberries.eklerk.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ProductAttribute.class)
public abstract class ProductAttribute_ {

	public static volatile SingularAttribute<ProductAttribute, Long> id;
	public static volatile ListAttribute<ProductAttribute, ProductAttributeValue> values;
	public static volatile SingularAttribute<ProductAttribute, String> name;
	public static volatile SingularAttribute<ProductAttribute, ProductAttributeType> type;
	public static volatile SingularAttribute<ProductAttribute, Boolean> main;

}

