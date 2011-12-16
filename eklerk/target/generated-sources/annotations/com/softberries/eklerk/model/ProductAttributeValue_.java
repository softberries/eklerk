package com.softberries.eklerk.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ProductAttributeValue.class)
public abstract class ProductAttributeValue_ {

	public static volatile SingularAttribute<ProductAttributeValue, Long> id;
	public static volatile SingularAttribute<ProductAttributeValue, String> value;
	public static volatile SingularAttribute<ProductAttributeValue, ProductAttribute> productAttribute;

}

