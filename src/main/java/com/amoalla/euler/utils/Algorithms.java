package com.amoalla.euler.utils;

public class Algorithms {
    public static class Primes {
        public static boolean isPrime(int number) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }

        public static boolean isCoprime(int... numbers) {
            return Math.gcd(numbers) == 1;
        }
    }

    public static class Math {
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
    }
}
