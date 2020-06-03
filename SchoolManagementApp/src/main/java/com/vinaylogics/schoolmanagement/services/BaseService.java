package com.vinaylogics.schoolmanagement.services;

import java.io.Serializable;
import java.util.List;

public interface BaseService <T extends Serializable, ID> {
    List<T> findAll();
    T findById(ID id);
    T save(T t);
    T update(T t);
    void deleteById(ID id);
    void delete(T t);

}
