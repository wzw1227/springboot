package com.wzw.springboot.util;
import java.math.BigInteger;
import java.security.MessageDigest;
public class Common<P extends Common> {

	public static String md5_2(String source) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(source.getBytes("utf-8"));
			byte[] digest = md5.digest();
			BigInteger code = new BigInteger(1, digest);
			return (code.toString(16)).toUpperCase();
		} catch (Exception e) {
			return null;
		}
	}
}
