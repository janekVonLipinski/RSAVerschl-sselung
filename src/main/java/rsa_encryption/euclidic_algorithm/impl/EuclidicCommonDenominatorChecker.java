package rsa_encryption.euclidic_algorithm.impl;

import rsa_encryption.euclidic_algorithm.GreatestCommonDenominatorChecker;
import rsa_encryption.euclidic_algorithm.MultiplicativeInverse;

public class EuclidicCommonDenominatorChecker implements GreatestCommonDenominatorChecker, MultiplicativeInverse {
    @Override
    public int getGreatestCommonDenomimnator(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;

        }
        return p;
    }

    @Override
    public int getMultiplicativeInverse(int number, int moduloNumber) {

        ResultEuclidicExtended result = getEuclidicExtendedResult(number, moduloNumber);

        if (result.gcd() != 1) {
            throw new IllegalArgumentException("Multiplicative inverse not found.");

        }
        return (result.x() % moduloNumber + moduloNumber) % moduloNumber;
    }

    private ResultEuclidicExtended getEuclidicExtendedResult(int number, int moduloNumber) {
        if (moduloNumber == 0) {
            return new ResultEuclidicExtended(number, 1, 0);
        }
        ResultEuclidicExtended next = getEuclidicExtendedResult(moduloNumber, number % moduloNumber);
        int gcd = next.gcd();
        int x = next.y();
        int y = next.x() - (number / moduloNumber) * next.y();

        return new ResultEuclidicExtended(gcd, x, y);
    }
}
