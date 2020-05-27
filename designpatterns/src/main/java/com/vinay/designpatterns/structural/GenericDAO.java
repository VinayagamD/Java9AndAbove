package com.vinay.designpatterns.structural;

import java.util.List;

public interface GenericDAO<D, ID> {

	public D findByID(ID id);
	public List<D> findAll();
	public D save(D d);
}
