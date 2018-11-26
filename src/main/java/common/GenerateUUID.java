package common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class GenerateUUID {
	public static synchronized String generate() {
		return UUID.randomUUID().toString();
	}
	
	public static synchronized String generate(String prefix) {
		if (prefix == null || prefix.length() == 0)
			return UUID.randomUUID().toString();

		return prefix + UUID.randomUUID().toString();
	}

	public static synchronized String generateNoHyphen(String prefix) {
		if (prefix == null)
			prefix = "";
		return prefix + UUID.randomUUID().toString().replace("-", "");
	}

	public static String generateByDigest(String prefix, String src) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (prefix == null)
			prefix = "";
		return prefix + digest(src);
	}

	public static String digest(String src) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = MessageDigest.getInstance("MD5"); // MD5를 사용한 이유는... ESG 서버에서 ID 길이를 최대 32로 잡고 있기 때문입니다.
		byte[] hash = digest.digest(src.getBytes("UTF-8"));

		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
