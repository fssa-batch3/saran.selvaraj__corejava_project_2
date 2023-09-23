package com.fssa.petmall.validation;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
public class PasswordEncryptAndDecrypt {

	public static SecretKey generateAES256Key(String hexKey) {
	    // Convert the hexadecimal string to bytes
	    byte[] keyBytes = hexStringToByteArray(hexKey);

	    // Create a SecretKey using SecretKeySpec
	    return new SecretKeySpec(keyBytes, "AES");
	}

	public static byte[] hexStringToByteArray(String hex) {
	    int len = hex.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
	                             + Character.digit(hex.charAt(i + 1), 16));
	    }
	    return data;
	}
	public static String encrypt(String plainText) throws Exception {
	    // Generate a secret key from the provided string
	    SecretKey key = generateAES256Key("2b7e151628aed2a6abf7158809cf4f3c2b7e151628aed2a6");
	    // Create a cipher instance
	    Cipher cipher = Cipher.getInstance("AES");

	    // Initialize the cipher for encryption
	    cipher.init(Cipher.ENCRYPT_MODE, key);

	    // Encrypt the plaintext
	    byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

	    // Encode the encrypted bytes as a Base64 string
	    return Base64.getEncoder().encodeToString(encryptedBytes);
	}

	public static String decrypt(String encryptedText) throws Exception {
	    // Generate a secret key from the provided string
		SecretKey key = generateAES256Key("2b7e151628aed2a6abf7158809cf4f3c2b7e151628aed2a6");

	    // Create a cipher instance
	    Cipher cipher = Cipher.getInstance("AES");

	    // Initialize the cipher for decryption
	    cipher.init(Cipher.DECRYPT_MODE, key);

	    // Decode the Base64 encoded string
	    byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);

	    // Decrypt the ciphertext
	    byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

	    // Convert the decrypted bytes to a string
	    return new String(decryptedBytes);
	}
}
