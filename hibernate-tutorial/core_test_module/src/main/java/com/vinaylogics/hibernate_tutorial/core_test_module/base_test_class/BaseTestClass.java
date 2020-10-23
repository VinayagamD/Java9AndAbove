package com.vinaylogics.hibernate_tutorial.core_test_module.base_test_class;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Properties;

public abstract class BaseTestClass {

    protected enum ConfigType {
        NORMAL,
        PROPERTIES
    }

    protected Properties properties;
    protected abstract File getFile();

    protected ConfigType getConfigType(){
        return ConfigType.NORMAL;
    }

    protected void loadProperties(InputStream stream){
        properties = new Properties();
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected SessionFactory sessionFactory;
    protected Session session;

    @BeforeEach
    public void setUp() {
        if (getConfigType() == ConfigType.PROPERTIES) {
            sessionFactory = new Configuration()
                    .configure(getFile()).addProperties(properties)
                    .buildSessionFactory();
        } else {
            sessionFactory = new Configuration().configure(getFile())
                    .buildSessionFactory();
        }

        session = sessionFactory.openSession();
    }

    @AfterEach
    public void tearDown() {
        session.close();
        sessionFactory.close();
    }
}
