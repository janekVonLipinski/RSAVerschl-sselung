package rsa_encryption.euclidic_algorithm.multiplicaitve_inverse.impl;

import org.junit.jupiter.api.Test;
import rsa_encryption.euclidic_algorithm.multiplicaitve_inverse.MultiplicativeInverseGenerator;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicateInverseCalculatorTest {

    private final MultiplicativeInverseGenerator sut = new MultiplicateInverseCalculator();

    @Test
    void givenNumberIsThreeAndModuloNumberIsTwentysix_then_resultIsNine(){
        int res = sut.getMultiplicativeInverse(3, 26);
        assertEquals(9, res);
    }

}