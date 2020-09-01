package com.vinaylogics.learnadvancejava.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class MyAnnotatedListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public MyAnnotatedListener() {
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
