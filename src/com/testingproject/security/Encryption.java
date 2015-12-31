package com.testingproject.security;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Class for simple encryption needs. Hides low level details for convenient
 * usage. User must specify 10 byte key.
 * 
 * @author K. Z. Win
 */
public class Encryption {

	/*
	 * TODO: make this user supplied or at least change it for each library
	 * usage
	 */
	private final static byte[] INIT_VECTOR = { 126, 72, -44, 37, -124, 120,
			78, -109, -51, 25, -34, 92, 27, -54, -115, -77 };
	private final static String XFORM = "AES/CBC/PKCS5Padding";
	private final static Logger LGR = Logger.getLogger(Encryption.class
			.getName());

	/*
	 * library-key: will be appended to user-key Change it if you know what you
	 * are doing
	 */
	private final static byte[] KEY = { 45, -128, -128, -34, 92, -76, 43, 59,
			-22, 3 };
	private byte[] encryption_key = new byte[16];
	private SecretKey secret_key;
	private Cipher cipher;
	private IvParameterSpec iv_parameter_spec;

	/**
	 * Constructor takes a byte array of 10 elements as user key.
	 * 
	 * @param user_key
	 */
	public Encryption(final byte[] user_key) {
		byte len = (byte) user_key.length;

		if (len != 10 && len != 6) {
			return;
		}
		System.arraycopy(KEY, 0, encryption_key, 0, len - 1);
		System.arraycopy(user_key, 0, encryption_key, len, 16 - len);
		secret_key = new SecretKeySpec(encryption_key, "AES");
		try {
			cipher = Cipher.getInstance(XFORM);
		} catch (NoSuchAlgorithmException ex) {
			LGR.log(Level.SEVERE, null, ex);
			System.exit(128);
		} catch (NoSuchPaddingException ex) {
			LGR.log(Level.SEVERE, null, ex);
			System.exit(127);
		}
		iv_parameter_spec = new IvParameterSpec(INIT_VECTOR);
	}

	/**
	 * Given a plain text, returns an encrypted text. Example
	 * <P>
	 * <code>
	 * &nbsp;Encryption enc = new Encryption(key_byte_array);<br>
	 * &nbsp;String to_save = enc.encrypt("secret");
	 * </code>
	 * 
	 * @param original_text
	 * @return encrypted text
	 */
	public String encrypt(String original_text) {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, secret_key, iv_parameter_spec);
			return string_from_byte(cipher.doFinal(original_text.getBytes()));
		} catch (IllegalBlockSizeException ex) {
			LGR.log(Level.SEVERE, null, ex);
		} catch (BadPaddingException ex) {
			LGR.log(Level.SEVERE, null, ex);
		} catch (InvalidKeyException ex) {
			LGR.log(Level.SEVERE, null, ex);
		} catch (InvalidAlgorithmParameterException ex) {
			LGR.log(Level.SEVERE, null, ex);
		}
		return null;
	}

	/**
	 * Given encrypted text, returns a plain text. Example
	 * <P>
	 * <code>
	 * &nbsp;Encryption enc = new Encryption(key_byte_array);<br>
	 * &nbsp;String password = enc.decrypt("....");
	 * </code>
	 * 
	 * @param encrypted_text
	 * @return original text
	 */
	public String decrypt(String encrypted_text) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, secret_key, iv_parameter_spec);
			return new String(cipher.doFinal(byte_from_string(encrypted_text)),
					"UTF-8");
		} catch (UnsupportedEncodingException ex) {
			LGR.log(Level.SEVERE, null, ex);
		} catch (IllegalBlockSizeException ex) {
			LGR.log(Level.SEVERE, null, ex);
		} catch (BadPaddingException ex) {
			LGR.log(Level.SEVERE, null, ex);
		} catch (InvalidKeyException ex) {
			LGR.log(Level.SEVERE, null, ex);
		} catch (InvalidAlgorithmParameterException ex) {
			LGR.log(Level.SEVERE, null, ex);
		} catch (NullPointerException e) {
			LGR.log(Level.SEVERE, null, e);
		}
		return null;
	}

	private byte[] byte_from_string(final String s) {
		final String[] w = s.split(",");
		final int len = w.length;
		final byte[] b = new byte[len];

		for (int i = 0; i < len; i++) {
			b[i] = Byte.parseByte(w[i]);
		}
		return b;
	}

	private String string_from_byte(final byte[] b) {
		String a = null;
		final int len = b.length - 1;

		if (b == null) {
			return a;
		}
		a = "";
		for (int i = 0; i < b.length; i++) {
			a += b[i];
			if (i == len) {
				break;
			}
			a += ',';
		}
		return a;
	}
}