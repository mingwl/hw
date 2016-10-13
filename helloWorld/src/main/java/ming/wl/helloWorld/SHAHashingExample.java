package ming.wl.helloWorld;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

public class SHAHashingExample {

	public static void main(String[] args) throws Exception {
		String password = "A";
		// String password = "61cf3e27-f024-4f9d-af44-b41b6659b385";

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());
		byte[] byteData = md.digest();

		String byteDataBase64 = Base64.encodeBase64URLSafeString(byteData);
		System.out.println("base64 format 0.0 : " + byteDataBase64);
		System.out.println("base64 format 0.0 : " + Base64.isBase64(byteDataBase64));

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		System.out.println("Hex format 1.0 : " + sb.toString());

		// convert the byte to hex format method 2
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			String hex = Integer.toHexString(0xff & byteData[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		System.out.println("Hex format 2.0 : " + hexString.toString());

		// convert the byte to hex format method 3
		String hex3 = Hex.encodeHexString(byteData);
		System.out.println("Hex format 3.1 : " + hex3);
		byte[] byte3 = Hex.decodeHex(hex3.toCharArray());
		System.out.println("Hex format 3.2 : " + Hex.encodeHexString(byte3));

		// apache commons codec
		String hex5 = DigestUtils.sha256Hex(password);
		System.out.println("Hex format 5.0 : " + hex5);

		// clientid
		UUID salt = UUID.fromString("029afe42-d8e7-11e2-aca1-50e549c9b611");
		String passwordToCheck = "812aa200c0912c9ea24bd76d790597bf5214837f3734cc0a47a73d2c39fe53d67aad4ad95da6207bdd8d9745fb8bb82ce6f65ea4b3d318fa0e70fcd6587c7412";
		String saltedPasswordToCheck = new StringBuilder(salt.toString()).append(passwordToCheck).toString();
		String hashedSaltedPasswordToCheck = DigestUtils.sha512Hex(saltedPasswordToCheck);
		System.out.println("salt : " + salt);
		System.out.println("passwordToCheck : " + passwordToCheck);
		System.out.println("saltedPasswordToCheck : " + saltedPasswordToCheck);
		System.out.println("hashedSaltedPasswordToCheck : " + hashedSaltedPasswordToCheck);

		String newPassword = "passw@rd密码４";
		String hashedPasswordToCheck = DigestUtils.sha512Hex(newPassword);
		System.out.println("newPassword : " + newPassword);
		System.out.println("hashedPasswordToCheck : " + hashedPasswordToCheck);

		List<String> aaa = new ArrayList<>();
		aaa.add("a");
		aaa.add("b");
		System.out.println(StringUtils.join(aaa, StringUtils.SPACE));
	}
}
