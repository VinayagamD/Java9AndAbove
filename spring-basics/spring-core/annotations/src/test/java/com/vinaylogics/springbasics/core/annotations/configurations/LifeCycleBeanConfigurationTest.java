package com.vinaylogics.springbasics.core.annotations.configurations;

import com.vinaylogics.springbasics.core.annotations.LifeCycleBean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LifeCycleBeanConfigurationTest extends BaseTestClass {

    @Override
    public Class<?> getConfigClass() {
        return LifeCycleBeanConfiguration.class;
    }

    @Test
    @DisplayName("Testing Bean Lifecycle")
    public void testBeanLifeCycle(){
        LifeCycleBean lifeCycleBean = context.getBean(LifeCycleBean.class);
    }
}