package com.web.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class TokenUtil {

	public static String createToken() {
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			StringBuilder sb = new StringBuilder();
			String data = UUID.randomUUID().toString();
			md5.update(data.getBytes());
			byte[] digest = md5.digest();
			for (byte b : digest) {
				sb.append(String.format("%02X", b)); // 10进制转16进制，X
														// 表示以十六进制形式输出，02
														// 表示不足两位前面补0输
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
}
