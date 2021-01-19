package com.vinaylogics.hibernate_tutorial.hql.criteria_query.models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Author.class)
public abstract class Author_ {

	public static volatile SetAttribute<Author, Book> books;
	public static volatile SingularAttribute<Author, String> name;
	public static volatile SingularAttribute<Author, Long> id;
	public static volatile SingularAttribute<Author, Integer> version;

	public static final String BOOKS = "books";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String VERSION = "version";

}

