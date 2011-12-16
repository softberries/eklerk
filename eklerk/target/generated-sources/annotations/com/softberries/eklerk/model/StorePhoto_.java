package com.softberries.eklerk.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(StorePhoto.class)
public abstract class StorePhoto_ {

	public static volatile SingularAttribute<StorePhoto, Long> id;
	public static volatile SingularAttribute<StorePhoto, String> fullPhotoUrl;
	public static volatile SingularAttribute<StorePhoto, String> thumbPhotoUrl;

}

