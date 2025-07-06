package rsa_encryption.encryption;

import rsa_encryption.euclidic_algorithm.common_denominator.GreatestCommonDenominatorCalculator;
import rsa_encryption.euclidic_algorithm.common_denominator.impl.EuclidicCommonDenominatorChecker;
import rsa_encryption.euclidic_algorithm.multiplicaitve_inverse.MultiplicativeInverseGenerator;
import rsa_encryption.euclidic_algorithm.multiplicaitve_inverse.impl.MultiplicateInverseCalculator;
import rsa_encryption.model.PrivateKey;
import rsa_encryption.model.PublicKey;
import rsa_encryption.prime_generator.PrimeGenerator;
import rsa_encryption.prime_generator.impl.StupidPrimeNumberGenerator;

import java.math.BigInteger;
import java.util.Random;

public class RSA {

    private final Random random = new Random();
    private final PrimeGenerator primeGenerator = new StupidPrimeNumberGenerator();
    private final GreatestCommonDenominatorCalculator greatestCommonDenominatorChecker = new EuclidicCommonDenominatorChecker();
    private final MultiplicativeInverseGenerator inverseGenerator = new MultiplicateInverseCalculator();
    private PrivateKey privateKey;
    private PublicKey publicKey;

    private static final int MIN_PRIME_NUMBER = 100;
    private static final int MAX_PRIME_NUMBER = 1000;

    public RSA() {
        generateKeyPair();
    }

    public void generateKeyPair() {

        int prime1 = primeGenerator.getLargestPrimeNumberUntilMax(
                random.nextInt(MIN_PRIME_NUMBER, MAX_PRIME_NUMBER)
        );

        int prime2 = primeGenerator.getLargestPrimeNumberUntilMax(
                random.nextInt(MIN_PRIME_NUMBER, MAX_PRIME_NUMBER)
        );

        int n = prime1 * prime2;
        int phi = (prime1 - 1) * (prime2 - 1);
        int e = getE(phi);
        int d = inverseGenerator.getMultiplicativeInverse(e, phi);

        BigInteger nAsBigInt = BigInteger.valueOf(n);
        BigInteger eAsBigInt = BigInteger.valueOf(e);
        BigInteger dAsBigInt = BigInteger.valueOf(d);

        PrivateKey privateKey = new PrivateKey(nAsBigInt, dAsBigInt);
        PublicKey publicKey = new PublicKey(nAsBigInt, eAsBigInt);
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public int encrypt(int message) {
        BigInteger n = publicKey.getN();
        BigInteger e = publicKey.getE();
        BigInteger data = BigInteger.valueOf(message);

        BigInteger ciphertext = data.modPow(e, n);

        return ciphertext.intValue();
    }

    public int decrypt(int dataToDecrypt) {
        BigInteger n = privateKey.getN();
        BigInteger d = privateKey.getD();
        BigInteger ciphertext = BigInteger.valueOf(dataToDecrypt);

        BigInteger decrypted = ciphertext.modPow(d, n);
        return decrypted.intValue();
    }


    private int getE(int phi) {
        int e;
        while (true) {
             e = random.nextInt(1, phi);
             int commonDenominator = greatestCommonDenominatorChecker.getGreatestCommonDenomimnator(phi, e);

             boolean isECoprimeToPhi = commonDenominator == 1;

             if (isECoprimeToPhi) {
                 break;
             }
        }
        return e;
    }
}
