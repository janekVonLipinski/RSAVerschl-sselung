package rsa_encryption.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;

@Getter
@RequiredArgsConstructor
@ToString
public class PublicKey {

    private final BigInteger n;
    private final BigInteger e;
}
