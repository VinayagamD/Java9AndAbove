package com.vinaylogics.springbasics.core.xml;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBeanLifeCycleTest extends BaseTestClass {

    @Override
    public String getConfigFile() {
        return "spring-config.xml";
    }

    @Test
    public void testLifeCycleMethod(){
        SimpleBeanLifeCycle simpleBean = (SimpleBeanLifeCycle) context.getBean("lifeCycleBean");
    }
}