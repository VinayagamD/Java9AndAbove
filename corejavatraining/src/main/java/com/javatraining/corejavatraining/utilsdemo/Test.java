package com.javatraining.corejavatraining.utilsdemo;

import com.javatraining.corejavatraining.utilsdemo.CalculatorUtils;

public class Test {

    public static void main(String[] args) {
        System.out.println(CalculatorUtils.performOperation(
                new SubtractionOperator(CalculatorUtils.performOperation(
                        new AdditionOperator(10L, 20L)),5L)));
    }
}
