package com.vinaylogics.springbasics.core.annotations.configurations;

import com.vinaylogics.springbasics.core.annotations.SimpleBean;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimpleConfigurationTest extends BaseTestClass {

    @Test
    void simpleBean() {
        SimpleBean simpleBean = context.getBean(SimpleBean.class);
        assertNotNull(simpleBean);
    }

    @Override
    public Class<?> getConfigClass() {
        return SimpleConfiguration.class;
    }
}