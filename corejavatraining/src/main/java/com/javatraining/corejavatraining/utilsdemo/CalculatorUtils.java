package com.javatraining.corejavatraining.utilsdemo;

public  class CalculatorUtils {

    public static Long performOperation(Operator operator){
        return operator.operate(operator.input1(),operator.input2());
    }
}
