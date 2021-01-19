package com.vinaylogics.hibernate_tutorial.hql.criteria_query.models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Address.class)
public abstract class Address_ {

	public static volatile SingularAttribute<Address, String> country;
	public static volatile SingularAttribute<Address, String> city;
	public static volatile SingularAttribute<Address, Integer> pinCode;

	public static final String COUNTRY = "country";
	public static final String CITY = "city";
	public static final String PIN_CODE = "pinCode";

}

