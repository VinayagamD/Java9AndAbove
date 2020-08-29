package com.javatraining.corejavatraining.immutable;

public class ImmutableDemo {
    public static void main(String[] args) {
        MyImmutable myImmutable = new MyImmutable("immutable1");
        myImmutable = new MyImmutable("immutable2");
        System.out.println(myImmutable.data);
    }
    public static class MyImmutable {
        public final String data;

        public MyImmutable(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }
}
