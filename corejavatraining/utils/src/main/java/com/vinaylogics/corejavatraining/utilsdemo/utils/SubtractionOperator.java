package com.vinaylogics.corejavatraining.utilsdemo.utils;

public class SubtractionOperator implements Operator{
    private final Long i1;
    private final Long i2;

    public SubtractionOperator(Long i1, Long i2) {
        this.i1 = i1;
        this.i2 = i2;
    }

    @Override
    public Long operate(Long i1, Long i2) {
        return i1;
    }

    @Override
    public Long input1() {
        return i2;
    }

    @Override
    public Long input2() {
        return i1 - i2;
    }
}
