package rsa_encryption.encryption;

import rsa_encryption.euclidic_algorithm.MultiplicativeInverse;
import rsa_encryption.prime_generator.PrimeGenerator;
import rsa_encryption.prime_generator.impl.StupidPrimeNumberGenerator;

import java.util.Random;

public class RSA {

    private final Random random = new Random();
    private final PrimeGenerator primeGenerator = new StupidPrimeNumberGenerator();
    private MultiplicativeInverse inverse;

    private static final int MIN_PRIME_NUMBER = 100;
    private static final int MAX_PRIME_NUMBER = 1000;

    public void generateKeyPair() {

        int prime1 = primeGenerator.getLargestPrimeNumberUntilMax(
                random.nextInt(MIN_PRIME_NUMBER, MAX_PRIME_NUMBER)
        );

        int prime2 = primeGenerator.getLargestPrimeNumberUntilMax(
                random.nextInt(MIN_PRIME_NUMBER, MAX_PRIME_NUMBER)
        );

        int n = prime1 * prime2;
        int phi = (prime1 - 1) * (prime2 - 1);

        int e = 0;

        while (true) {
             e = random.nextInt(1, phi);
             inverse.getMultiplicativeInverse();
        }
    }
}
