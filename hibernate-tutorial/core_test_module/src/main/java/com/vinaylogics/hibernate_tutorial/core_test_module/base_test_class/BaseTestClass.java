package com.vinaylogics.hibernate_tutorial.core_test_module.base_test_class;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;

public abstract class BaseTestClass {

    protected abstract File getFile();

    protected SessionFactory sessionFactory;
    protected Session session;

    @BeforeEach
    public void setUp() {
        sessionFactory = new Configuration().configure(getFile())
                .buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @AfterEach
    public void tearDown() {
        session.close();
        sessionFactory.close();
    }
}
