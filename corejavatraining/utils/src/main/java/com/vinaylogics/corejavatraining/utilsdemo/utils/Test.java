package com.vinaylogics.corejavatraining.utilsdemo.utils;

public class Test {

    public static void main(String[] args) {
        System.out.println(CalculatorUtils.performOperation(
                new SubtractionOperator(CalculatorUtils.performOperation(
                        new AdditionOperator(10L, 20L)),5L)));
    }
}
