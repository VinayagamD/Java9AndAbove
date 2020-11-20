package com.vinaylogics.springbasics.core.annotations;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.PostMapping;

public class LifeCycleBean implements InitializingBean, DisposableBean, BeanFactoryAware, ApplicationContextAware, BeanNameAware {
    @Override
    public void destroy() throws Exception {
        System.out.println("Before Bean Destroyed");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After Bean Property set");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Set Bean Factory");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application Context Aware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name Aware");
    }

    public void postConstruct(){
        System.out.println("Post Construct");
    }

    public void preDestroy(){
        System.out.println("Pre Destroy");
    }
}
