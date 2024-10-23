package com.amoalla.euler.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Math.sqrt;

public class Algorithms {
    public static class Primes {
        public record PrimeFactor(int prime, int exponent) {}

        public static List<PrimeFactor> factor(int n) {
            List<PrimeFactor> primeFactors = new ArrayList<>();
            for (int prime : primes()) {
                if (n % prime == 0) {
                    int exponent = 0;
                    while (n % prime == 0) {
                        n /= prime;
                        exponent++;
                    }
                    primeFactors.add(new PrimeFactor(prime, exponent));
                }

                if (n == 1) break;
            }
            return primeFactors;
        }

        public static Iterable<Integer> primes() {
            return () -> new Iterator<>() {
                private int counter = 2;

                @Override
                public boolean hasNext() {
                    return true;
                }

                @Override
                public Integer next() {
                    int number = counter;
                    while (!isPrime(number)) {
                        number++;
                    }
                    counter = number + 1;
                    return number;
                }
            };
        }

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
}
