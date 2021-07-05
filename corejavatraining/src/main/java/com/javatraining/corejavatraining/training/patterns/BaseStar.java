package com.javatraining.corejavatraining.training.patterns;

public abstract class BaseStar extends BasePattern implements OperationStar{

    @Override
    public void travelRows(int rows) {
        for (int row = 1; row <= rows; row++) {
            travelSpace(rows-row);
            travelStar(row);
            System.out.println();
        }
    }

    public void askPatterns(){
        System.out.println("Enter pattern string for "+getPatternName());
        setPattern(getScanner().next());
    }

    @Override
    public void travelRemainingRows(int rows) {
        for (int row =rows-1; row > 0; row--) {
            travelSpace(rows-row);
            travelStar(row);
            System.out.println();
        }
    }

    @Override
    public void travelSpace(int row) {
        for (int space = 1; space <=row; space++) {
            System.out.print("  ");
        }
    }

    @Override
    public void travelStar(int row) {
        for (int star = 1; star <= (2*row)-1; star++){
            System.out.print(getPattern()+" ");
        }
    }
}
