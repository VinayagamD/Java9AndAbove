package com.vinaylogics.springbasics.core.annotations;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LifeCycleBean implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("Before Bean Destroyed");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After Bean Creat");
    }
}
