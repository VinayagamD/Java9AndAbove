package com.vinaylogics.corejavatraining.exception;

public class TestCheckedException {

    public static void main(String[] args){
        try {
            throw new MyException(10001, "Purposefully exception");
        } catch (MyException e) {
            System.out.println(e.getMessage());
            System.err.println(e.getMessage());
            System.out.println(e.getExceptionCode());
        }catch (Exception e){
            e.printStackTrace();
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println("Always Executed");
        }
    }
}
