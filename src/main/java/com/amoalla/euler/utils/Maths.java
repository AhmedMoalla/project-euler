package com.amoalla.euler.utils;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Maths {
    public static Iterable<BigInteger> fibonacciBig() {
        return () -> new Iterator<>() {
            private BigInteger beforePreviousValue = BigInteger.ONE;
            private BigInteger previousValue = BigInteger.ONE;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public BigInteger next() {
                BigInteger nextValue = previousValue.add(beforePreviousValue);
                beforePreviousValue = previousValue;
                previousValue = nextValue;
                return nextValue;
            }
        };
    }

    public static LongStream fibonacciStream() {
        return Stream.iterate(new long[]{0, 1}, i -> new long[]{i[1], i[0] + i[1]})
                .map(i -> i[0]).mapToLong(Long::longValue);
    }

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