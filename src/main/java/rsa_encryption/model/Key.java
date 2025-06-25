package rsa_encryption.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class Key {

    private final int n;
    private final int eOrD;
}
