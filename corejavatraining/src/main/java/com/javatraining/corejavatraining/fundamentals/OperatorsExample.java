package com.javatraining.corejavatraining.fundamentals;

public class OperatorsExample {

    public static void main(String[] args) {
//        Arithmetic Operator
        System.out.println("====================== Arithmetic Operator ============================");
        System.out.println(2 + 3);
        System.out.println(3-2);
        System.out.println(3*2);
        System.out.println(3/2.0);
        System.out.println(3/2);
        System.out.println(4/2);
        System.out.println(4%2);
        System.out.println(3%2);

      System.out.println("================ Increment Example ============================");
        int sum = 2;
        int data = sum ++;
        System.out.println(data);
        System.out.println(sum);
        data = ++ sum;
        System.out.println(data);
        System.out.println(sum);

       System.out.println("====================== Relational Operator ============================");
//        Relational Operator
        System.out.println(1 == 1);
        System.out.println(1 != 1);
        System.out.println(1 < 2);
        System.out.println(1 > 2);
        System.out.println(1 <= 2);
        System.out.println(1 <= 1);
        System.out.println(1 < 1);
        System.out.println(1 >= 1);
        System.out.println(1 >= 2);
      System.out.println("====================== Logical Operator ============================");
//        Logical Operator
       System.out.println(true && true);
       System.out.println(true && false);
       System.out.println(false && true);
       System.out.println(false && false);
       System.out.println(true || true);
       System.out.println(true || false);
       System.out.println(false || true);
       System.out.println(false || false);
       System.out.println(!true);
       System.out.println(!false);
       System.out.println("====================== Bitwise Operator ============================");
//        Bitwise Operator
        System.out.println(2&6);
        System.out.println(2|4);
        System.out.println(2^4);
        System.out.println(4^6);
        System.out.println(~4);
        System.out.println(4 <<1); // 0 0 0 0
        System.out.println(4 <<3); // 0 0 0 0
        System.out.println(4 >>> 3); // 0 0 0 0
        System.out.println(4 >>1);
        System.out.println(4 >>3);
        System.out.println("==================== Ternary Example ========================");
        System.out.println(true? "Statement 1 " : "Statement 2");
        System.out.println(false? "Statement 1 " : "Statement 2");
    }
}
