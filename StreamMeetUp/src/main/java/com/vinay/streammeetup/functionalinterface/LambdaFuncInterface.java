package com.vinay.streammeetup.functionalinterface;

public class LambdaFuncInterface {
    public static void main(String[] args) {
        int width = 10;
        Drawable drawable = new Drawable() {
            @Override
            public void draw() {
                System.out.println("Imperative Drawing width "+ width);
            }
        };
        drawable.draw();

        Drawable funcDrawable = () -> System.out.println("Functional Drawable width " + width);
        funcDrawable.draw();
    }
}
