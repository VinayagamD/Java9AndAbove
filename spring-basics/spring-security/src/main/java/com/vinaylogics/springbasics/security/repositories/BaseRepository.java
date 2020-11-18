package com.vinaylogics.springbasics.security.repositories;

import java.util.List;

public interface BaseRepository<T, PK> {
    T save(T t);
    T update(T t);
    List<T> findAll();
    T findById(PK id);
    boolean delete(T t);
    boolean deleteById(PK id);
}
