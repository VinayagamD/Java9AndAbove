package com.vinaylogics.springbasics.springsecurity.repository.impl;

import com.vinaylogics.springbasics.springsecurity.models.Role;
import com.vinaylogics.springbasics.springsecurity.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public Role update(Role role) {
        return null;
    }

    @Override
    public List<Role> findAll() {
        TypedQuery<Role> query = entityManager.createNamedQuery("findAllRole", Role.class);
        return query.getResultList();
    }

    @Override
    public Role findById(Long aLong) {
        return null;
    }

    @Override
    public boolean delete(Role role) {
        return false;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }
}
