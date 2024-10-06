package com.university.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordUtil {

	/**
	 * 사용자 계정을 새로 생성하거나 로그인할 때 입력된 비밀번호가 데이터베이스에 
	 * 저장된 hashed된 비밀번호랑 일치하는지 확인할 때 쓰는 메소드입니다.
	 * 
	 * @param password 문자열로 된 일반 비밀번호
	 * @param salt     비밀번호를 hashing할 때 필요한 16byte의 salt
	 * @return         hashed된 비밀번
	 */
	public static String hashPassword(String password, byte[] salt) {
		int iterations = 66536;
		int keyLength = 256;
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);
		
		SecretKeyFactory factory = null;
		byte[] hashedBytes = null;
		
		try {
			// set internal hashing algorithm to SHA256
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");  
			hashedBytes = factory.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		String hashedPassword = Base64.getEncoder().encodeToString(hashedBytes);
		return hashedPassword;
	}
	
	/**
	 * 새로운 계정을 생성할 때 salt 항목에 넣을 랜덤 salt를 생성하는 메소드입니다.
	 * 
	 * @return 16 byte 길이의 salt
	 */
	public static byte[] generateSalt() {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		return salt;
	}	
}
