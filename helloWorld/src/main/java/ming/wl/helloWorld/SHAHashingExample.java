package ming.wl.helloWorld;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;

public class SHAHashingExample {

	public static void main(String[] args) throws Exception {
		String password = "A";
		// String password = "61cf3e27-f024-4f9d-af44-b41b6659b385";

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());
		byte[] byteData = md.digest();

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
	}
}
