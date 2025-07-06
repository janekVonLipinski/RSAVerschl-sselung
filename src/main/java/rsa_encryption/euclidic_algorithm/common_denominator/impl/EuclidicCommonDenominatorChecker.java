package rsa_encryption.euclidic_algorithm.common_denominator.impl;

import rsa_encryption.euclidic_algorithm.common_denominator.GreatestCommonDenominatorCalculator;

public class EuclidicCommonDenominatorChecker implements GreatestCommonDenominatorCalculator {
    @Override
    public int getGreatestCommonDenomimnator(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;

        }
        return p;
    }


}
