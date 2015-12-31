package com.testingproject.security;

public class EncryptDecrypt {

	public static void main(String args[]) {
		String plain_text = "naeem";
		byte[] b = { 2, 9, -3, 8, 88, -25, 77, 13, -4, -51 };
		Encryption enc = new Encryption(b);
		String enc_string = enc.encrypt(plain_text);
		System.out.println("plain text ===== " + plain_text
				+ "   Encrypted String = " + enc_string);

		String dec_string = enc
				.decrypt("71,-116,122,105,86,-51,-104,-124,-89,-37,123,23,-65,-55,47,44");

		System.out.println("encrypt key ==" + enc_string
				+ "    it's Decryption =" + dec_string);

	}
}
