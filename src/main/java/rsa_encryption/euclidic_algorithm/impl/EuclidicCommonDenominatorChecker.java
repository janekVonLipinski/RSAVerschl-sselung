package rsa_encryption.euclidic_algorithm.impl;

import rsa_encryption.euclidic_algorithm.GreatestCommonDenominatorChecker;

public class EuclidicCommonDenominatorChecker implements GreatestCommonDenominatorChecker {
    @Override
    public int getGreatestCommonDenomimnator(int p, int q) {
        while (q != 0){
            int temp = q;
            q = p % q;
            p = temp;

        }
        return p;
    }
}
