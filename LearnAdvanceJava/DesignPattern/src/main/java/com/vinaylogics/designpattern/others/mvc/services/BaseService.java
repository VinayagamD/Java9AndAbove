package com.vinaylogics.designpattern.others.mvc.services;

import com.vinaylogics.designpattern.exception.ServiceException;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<T extends Serializable, ID extends Number> {
    List<T> findAll() throws ServiceException;

    Optional<T> findById(ID id) throws ServiceException;

    Optional<T> save(T t) throws ServiceException;

    Optional<T> update(T t, ID id) throws  ServiceException;

    boolean delete(T t) throws ServiceException;

    boolean deleteById(ID id) throws ServiceException;
}
