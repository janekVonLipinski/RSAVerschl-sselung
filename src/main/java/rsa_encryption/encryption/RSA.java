package rsa_encryption.encryption;

import rsa_encryption.euclidic_algorithm.GreatestCommonDenominatorChecker;
import rsa_encryption.euclidic_algorithm.MultiplicativeInverse;
import rsa_encryption.euclidic_algorithm.impl.EuclidicCommonDenominatorChecker;
import rsa_encryption.model.Key;
import rsa_encryption.prime_generator.PrimeGenerator;
import rsa_encryption.prime_generator.impl.StupidPrimeNumberGenerator;

import java.math.BigInteger;
import java.util.Random;

public class RSA {

    private final Random random = new Random();
    private final PrimeGenerator primeGenerator = new StupidPrimeNumberGenerator();
    private final GreatestCommonDenominatorChecker greatestCommonDenominatorChecker = new EuclidicCommonDenominatorChecker();
    private final MultiplicativeInverse inverse = new EuclidicCommonDenominatorChecker();
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
        int e = getE(phi);
        int d = inverse.getMultiplicativeInverse(e, phi);

        BigInteger nAsBigInt = BigInteger.valueOf(n);
        BigInteger eAsBigInt = BigInteger.valueOf(e);
        BigInteger dAsBigInt = BigInteger.valueOf(d);

        Key privateKey = new Key(nAsBigInt, dAsBigInt);
        Key publicKey = new Key(nAsBigInt, eAsBigInt);
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public int encrypt(int dataToEncrypt) {
        BigInteger n = publicKey.getN();
        BigInteger e = publicKey.getEOrD();
        BigInteger data = BigInteger.valueOf(dataToEncrypt);

        BigInteger ciphertext = data.modPow(e, n);

        return ciphertext.intValue();
    }

    public int decrypt(int dataToDecrypt) {
        BigInteger n = privateKey.getN();
        BigInteger d = privateKey.getEOrD();
        BigInteger ciphertext = BigInteger.valueOf(dataToDecrypt);

        BigInteger decrypted = ciphertext.modPow(d, n);
        return decrypted.intValue();
    }


    private int getE(int phi) {
        int e;
        while (true) {
             e = random.nextInt(1, phi);
             int commonDenominator = greatestCommonDenominatorChecker.getGreatestCommonDenomimnator(phi, e);

             if (commonDenominator == 1) {
                 break;
             }
        }
        return e;
    }
}
