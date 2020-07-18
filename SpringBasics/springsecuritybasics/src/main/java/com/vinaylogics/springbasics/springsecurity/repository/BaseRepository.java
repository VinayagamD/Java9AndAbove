package com.vinaylogics.springbasics.springsecurity.repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BaseRepository<T,ID> {

    T save(T t);
    T update(T t);
    List<T> findAll();
    T findById(ID id);
    boolean delete(T t);
    boolean deleteById(ID id);

}
