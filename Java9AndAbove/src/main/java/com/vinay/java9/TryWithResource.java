package com.vinay.java9;

/**
* Both in life and programming we solve one set of problem only to
 * find that we have created a new of problem
* */

// Java 7 Introduced try with resource
// Java 9 deprecated finalize method

class Resource implements AutoCloseable{
    public Resource() {
        System.out.println("creating external resource");
    }

    public void op1(){
        System.out.println("op1");
    }

   /* @Override
    protected void finalize() throws Throwable {
        System.out.println("clean up external resources....");
    }*/

    @Override
    public void close() throws Exception {
        System.out.println("clean up external resources....");
    }
}

// new is four letter word - tight coupling

public class TryWithResource {

    public static void main(String[] args) {
        use(new Resource());
    }

    public static void use(Resource resource) {
        try (resource) {
            resource.op1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
