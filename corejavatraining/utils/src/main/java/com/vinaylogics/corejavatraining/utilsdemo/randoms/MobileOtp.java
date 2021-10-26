package com.vinaylogics.corejavatraining.utilsdemo.randoms;

import java.util.Random;
import java.util.Scanner;

public class MobileOtp {

    static char[] generateOtp(int len)
    {
        System.out.println("Generating OTP using random() : ");
        System.out.print("You OTP is : ");

        // Using numeric values
        String numbers = "0123456789";

        // Using random method
        Random random = new Random();

        char[] otp = new char[len];

        for (int i = 0; i < len; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            otp[i] = numbers.charAt(random.nextInt(numbers.length()));
        }
        return otp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(generateOtp(scanner.nextInt()));
    }
}
