package com.softberries.eklerk.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, Long> id;
	public static volatile SingularAttribute<Order, Date> dateFinished;
	public static volatile SingularAttribute<Order, Date> dateStarted;
	public static volatile ListAttribute<Order, Product> products;

}

