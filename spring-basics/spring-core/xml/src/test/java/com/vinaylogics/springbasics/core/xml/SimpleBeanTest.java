package com.vinaylogics.springbasics.core.xml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBeanTest extends BaseTestClass{

    @Override
    public String getConfigFile() {
        return "spring-config.xml";
    }



    @Test
    @DisplayName("To Create Simple Bean")
    public void testCreateSimpleBean(){
       assertNotNull(context);
       SimpleBean simpleBean  = (SimpleBean) context.getBean("simpleBean");
       assertNotNull(simpleBean);
       assertNull(simpleBean.getName());
       System.out.println(simpleBean);
    }

    @Test
    @DisplayName("To Create Simple Bean")
    public void testCreateSimpleBean_WithProperties(){
       assertNotNull(context);
       SimpleBean simpleBean  = (SimpleBean) context.getBean("simpleBean2");
       assertNotNull(simpleBean);
       assertNotNull(simpleBean.getName());
       System.out.println(simpleBean);
    }
}