package com.testingproject.jsaypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;

public class EncryptionDecryption {

	public static void main(String[] args) {

		String userPassword = "test";
		String encUserPassword = "";
		StrongPasswordEncryptor enc = new StrongPasswordEncryptor();
		encUserPassword = enc.encryptPassword(userPassword);
		System.out.println("Encrypted Password ==>" + encUserPassword);

		// boolean decUserPassword = dec
		// .checkPassword("test",
		// "t8qlsafQCZBUJLDXKzbcYbWrZyMD18DRw8SZF/FvceraUwt1+WK5aCwPPRRkRZoO");
		// System.out.println("Boolearn value =" + decUserPassword);

		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword("test");
		String decrypt = encryptor.decrypt(encUserPassword);

		System.out.println("decrypt message = " + decrypt);

	}
}
