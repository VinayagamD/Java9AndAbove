package com.vinaylogics.hibernate_tutorial.hql.criteria_query.models;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile SingularAttribute<Book, Long> id;
	public static volatile SingularAttribute<Book, LocalDateTime> publishedDate;
	public static volatile SingularAttribute<Book, String> title;
	public static volatile SingularAttribute<Book, Integer> version;
	public static volatile SetAttribute<Book, Author> authors;

	public static final String ID = "id";
	public static final String PUBLISHED_DATE = "publishedDate";
	public static final String TITLE = "title";
	public static final String VERSION = "version";
	public static final String AUTHORS = "authors";

}

