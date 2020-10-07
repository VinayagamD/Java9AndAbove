package com.vinaylogics.designpattern.others.mvc.daos;

import com.vinaylogics.designpattern.exception.DaoException;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseDao<T extends Serializable, ID extends Number> {

    List<T> findAll() throws DaoException;

    Optional<T> findById(ID id) throws DaoException;

    Optional<T> save(T t) throws DaoException;

    Optional<T> update(T t, ID id) throws  DaoException;

    boolean delete(T t) throws DaoException;

    boolean deleteById(ID id) throws DaoException;

}
