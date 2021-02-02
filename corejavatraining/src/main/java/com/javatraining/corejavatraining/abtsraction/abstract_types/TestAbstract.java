package com.javatraining.corejavatraining.abtsraction.abstract_types;

public class TestAbstract {

    public static void main(String[] args) {
        EgAbstract egAbstract = new EgAbstract() {
            @Override
            public void testMethod2() {

            }

            @Override
            public void testMethod3() {

            }

            @Override
            public void testMethod4() {

            }
        };

        egAbstract.testMethod();

        egAbstract = new Derived();

  
    }
}
