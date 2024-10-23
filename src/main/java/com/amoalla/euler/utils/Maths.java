package com.amoalla.euler.utils;

import java.math.BigInteger;

public class Maths {
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static int gcd(int... numbers) {
        int result = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            result = gcd(result, numbers[i]);

            if (result == 1) {
                break;
            }
        }
        return result;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int max(int... numbers) {
        int max = numbers[0];
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}