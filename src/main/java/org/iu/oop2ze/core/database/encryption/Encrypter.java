package org.iu.oop2ze.core.database.encryption;

import jakarta.persistence.AttributeConverter;
import org.apache.commons.lang3.SerializationUtils;
import org.iu.oop2ze.core.helpers.EnviromentHelper;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.Key;
import java.util.Base64;

/**
 * Klasse, welche Entity Attribute Verschlüsselt
 *
 * @author Julius Beier
 */
public class Encrypter<T extends Serializable> implements AttributeConverter<T, String> {
    private static final String AES = "AES";
    private static final String SECRET = EnviromentHelper.gibEncryptionSecret();

    private final Key key;
    private final Cipher cipher;

    public Encrypter() throws Exception {
        key = new SecretKeySpec(SECRET.getBytes(), AES);
        cipher = Cipher.getInstance(AES);
    }

    @Override
    public String convertToDatabaseColumn(T data) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] bytes = SerializationUtils.serialize(data);
            return Base64.getEncoder().encodeToString(cipher.doFinal(bytes));
        } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public T convertToEntityAttribute(String data) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            return SerializationUtils.deserialize(cipher.doFinal(Base64.getDecoder().decode(data)));
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            throw new IllegalStateException(e);
        }
    }
}
