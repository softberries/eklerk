package com.softberries.eklerk.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ProductAttributeType.class)
public abstract class ProductAttributeType_ {

	public static volatile SingularAttribute<ProductAttributeType, Long> id;
	public static volatile SingularAttribute<ProductAttributeType, String> type;

}

