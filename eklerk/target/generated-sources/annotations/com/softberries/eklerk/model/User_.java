package com.softberries.eklerk.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, String> phoneNumber;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, String> password;

}

