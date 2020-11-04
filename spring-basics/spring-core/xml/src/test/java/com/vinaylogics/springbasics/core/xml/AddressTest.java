package com.vinaylogics.springbasics.core.xml;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest extends BaseTestClass {

    @Override
    public String getConfigFile() {
        return "spring-config.xml";
    }

    @Test
    @DisplayName("To show property initailization")
    public void testAddressPropertyInitialization(){
      Address address  = (Address) context.getBean("address");
      assertNotNull(address);
      assertNotNull(address.getAddressList());
      assertNotNull(address.getAddressMap());
      assertNotNull(address.getAddressSet());
      assertNotNull(address.getName());
      assertNotNull(address.getProperties());
      assertNull(address.getNullName());
      System.out.println(address);
    }
}