package com.amoalla.euler.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Math.sqrt;

public class Primes {
    public record PrimeFactor(int prime, int exponent) {
    }

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
        return Maths.gcd(numbers) == 1;
    }
}