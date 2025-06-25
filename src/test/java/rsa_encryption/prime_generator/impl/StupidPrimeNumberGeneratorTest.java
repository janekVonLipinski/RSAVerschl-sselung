package rsa_encryption.prime_generator.impl;

import org.junit.jupiter.api.Test;
import rsa_encryption.prime_generator.PrimeGenerator;

import static org.junit.jupiter.api.Assertions.*;

class StupidPrimeNumberGeneratorTest {

    private final PrimeGenerator sut = new StupidPrimeNumberGenerator();

    @Test
    void given_PrimeNumberGeneratorWith_8_Then_resultIs7() {
        var res = sut.getLargestPrimeNumberUntilMax(8);

        assertEquals(7, res);
    }

}