package com.vinaylogics.springboot.springmvccore.services;

import java.util.List;

public interface BasicService <T, PK>{
    List<T> findAll();
    T findById(PK id);
    T save(T t);
    T update(PK id, T t);
    void delete(T t);
    void deleteById(PK id);
}
