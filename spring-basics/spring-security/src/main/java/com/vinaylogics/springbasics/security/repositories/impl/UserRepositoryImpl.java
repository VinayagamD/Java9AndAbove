package com.vinaylogics.springbasics.security.repositories.impl;

import com.vinaylogics.springbasics.security.models.User;
import com.vinaylogics.springbasics.security.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findByUsername(String username) {
        TypedQuery<User> query = entityManager.createNamedQuery("findByUsername",User.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

    @Override
    public User save(User user) {
        return entityManager.merge(user);
    }

    @Override
    public User update(User user) {
        return  entityManager.merge(user);
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createNamedQuery("findAll",User.class);
        return query.getResultList();
    }

    @Override
    public User findById(Long id) {
        TypedQuery<User> query = entityManager.createNamedQuery("findById",User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
