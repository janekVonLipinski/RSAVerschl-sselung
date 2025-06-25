package rsa_encryption;

import rsa_encryption.encryption.RSA;

public class Main {

    public static void main(String[] args) {

        RSA rsa = new RSA();

        rsa.generateKeyPair();
        int message = 8;
        System.out.println("Message is " + message);

        int encryptedMessage = rsa.encrypt(message);
        System.out.println("Encrypted is " + encryptedMessage);

        int decryptedMessage = rsa.decrypt(encryptedMessage);
        System.out.println("Mesage is " + decryptedMessage);
    }
}
