package ming.wl.encryption;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import org.apache.commons.lang3.ArrayUtils;

public class TestEncryption {

	public static void main(String[] args) throws Exception {
		UUID key = UUID.randomUUID();
		UUID password = UUID.randomUUID();
		byte[] encryptionKey = ArrayUtils.subarray(key.toString().getBytes(StandardCharsets.UTF_8), 0, 16);
		// byte[] encryptionKey = key.toString().getBytes(StandardCharsets.UTF_8);
		byte[] plainText = password.toString().getBytes(StandardCharsets.UTF_8);
		// byte[] encryptionKey =
		// "MZygpewJsCpRrfOr".getBytes(StandardCharsets.UTF_8);
		// byte[] plainText = "Hello world!".getBytes(StandardCharsets.UTF_8);
		AdvancedEncryptionStandard advancedEncryptionStandard = new AdvancedEncryptionStandard(encryptionKey);
		byte[] cipherText = advancedEncryptionStandard.encrypt(plainText);
		byte[] decryptedCipherText = advancedEncryptionStandard.decrypt(cipherText);

		System.out.println(new String(plainText));
		System.out.println(new String(cipherText));
		System.out.println(new String(decryptedCipherText));
	}

}
