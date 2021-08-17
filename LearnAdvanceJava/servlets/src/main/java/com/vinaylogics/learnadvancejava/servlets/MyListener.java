package com.vinaylogics.learnadvancejava.servlets;


import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public MyListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Listeners for context created");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Listeners for context destroyed");
    }


}
