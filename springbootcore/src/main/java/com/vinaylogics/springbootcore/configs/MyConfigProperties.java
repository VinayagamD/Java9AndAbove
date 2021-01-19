package com.vinaylogics.springbootcore.configs;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
@ConfigurationProperties(prefix = "myconfig")
public class MyConfigProperties {

    private String prop1;
    private String prop2;

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    public String getProp2() {
        return prop2;
    }

    public void setProp2(String prop2) {
        this.prop2 = prop2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyConfigProperties that = (MyConfigProperties) o;
        return Objects.equals(prop1, that.prop1) && Objects.equals(prop2, that.prop2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prop1, prop2);
    }

    @Override
    public String toString() {
        return "MyConfigProperties{" +
                "prop1='" + prop1 + '\'' +
                ", prop2='" + prop2 + '\'' +
                '}';
    }
}
