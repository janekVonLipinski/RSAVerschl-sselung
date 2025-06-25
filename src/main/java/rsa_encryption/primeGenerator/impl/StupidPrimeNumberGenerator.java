package rsa_encryption.primeGenerator.impl;

import rsa_encryption.primeGenerator.PrimeGenerator;

import java.util.ArrayList;
import java.util.List;

public class StupidPrimeNumberGenerator implements PrimeGenerator {

    @Override
    public int getLargestPrimeNumberUntilMax(int max) {

        int largestPrime = 0;

        for (int i = 0; i < max; i++) {
            if (isPrime(i)) {
                largestPrime = i;
            }
        }

        return largestPrime;
    }

    private boolean isPrime(long number) {
        long numberToTest = Math.abs(number);

        if (numberToTest < 2) {
            return false;
        }

        for (int divisor = 2; divisor < number; divisor++) {
            if (numberToTest % divisor == 0) {
                return false;
            }
        }

        return true;
    }
}
