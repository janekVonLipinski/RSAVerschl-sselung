package rsa_encryption.encryption;

import rsa_encryption.euclidic_algorithm.GreatestCommonDenominatorChecker;
import rsa_encryption.euclidic_algorithm.MultiplicativeInverse;
import rsa_encryption.model.Key;
import rsa_encryption.prime_generator.PrimeGenerator;
import rsa_encryption.prime_generator.impl.StupidPrimeNumberGenerator;

import java.util.Random;

public class RSA {

    private final Random random = new Random();
    private final PrimeGenerator primeGenerator = new StupidPrimeNumberGenerator();
    private GreatestCommonDenominatorChecker greatestCommonDenominatorChecker;
    private MultiplicativeInverse inverse;
    private Key privateKey;
    private Key publicKey;

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

        int e;

        while (true) {
             e = random.nextInt(1, phi);
             int commonDenominator = greatestCommonDenominatorChecker.getGreatestCommonDenomimnator(phi, e);

             if (commonDenominator == 1) {
                 break;
             }
        }

        int d = inverse.getMultiplicativeInverse();

        Key privateKey = new Key(n, d);
        Key publicKey = new Key(n, e);
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }
}
