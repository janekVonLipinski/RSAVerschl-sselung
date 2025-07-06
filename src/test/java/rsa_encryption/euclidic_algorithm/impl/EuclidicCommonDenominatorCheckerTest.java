package rsa_encryption.euclidic_algorithm.impl;

import org.junit.jupiter.api.Test;
import rsa_encryption.euclidic_algorithm.common_denominator.impl.EuclidicCommonDenominatorChecker;

import static org.junit.jupiter.api.Assertions.*;

class EuclidicCommonDenominatorCheckerTest {

    private final EuclidicCommonDenominatorChecker sut = new EuclidicCommonDenominatorChecker();


    @Test
    void test() {
    int res = sut.getGreatestCommonDenomimnator(12, 15);
    assertEquals(3, res);
    }
}