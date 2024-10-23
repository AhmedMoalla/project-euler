package com.amoalla.euler.utils;

import static java.lang.Math.sqrt;

public class Algorithms {
    public static class Primes {
        public static boolean isPrime(int number) {
            if (number <= 1) return false;
            if (number == 2) return true;
            if (number % 2 == 0) return false;
            for (int i = 3; i <= sqrt(number); i += 2) {
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
}
