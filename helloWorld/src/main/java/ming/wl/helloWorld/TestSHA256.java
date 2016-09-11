package ming.wl.helloWorld;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;

public class TestSHA256 {

	public static void main(String[] args) {
    try {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest("A".getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (int i: hash) {
//            hexString.append(Integer.toHexString(0XFF & i));
        	hexString.append(String.format("%02x", 0XFF & i));
        }
        System.out.println(hexString);
        
        String hex = Hex.encodeHexString(hash);
        System.out.println(hex);
        
        byte[] hash2 = Hex.decodeHex(hex.toCharArray());
        System.out.println(Hex.encodeHex(hash2));
        
    } catch (Exception e) {
        e.printStackTrace();
    }
	}
}
