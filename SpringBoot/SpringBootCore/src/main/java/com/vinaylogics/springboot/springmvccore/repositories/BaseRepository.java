package com.vinaylogics.springboot.springmvccore.repositories;

import java.util.List;
import java.util.Optional;

public interface BaseRepository <T, PK> {
    List<T> findAll();
    Optional<T> findById(PK id);
    T save(T t);
    T update(PK id, T t);
    void delete(T t);
    void deleteById(PK id);
}
