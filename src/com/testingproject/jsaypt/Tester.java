package com.testingproject.jsaypt;

public class Tester {

	public Tester() {
	}

	public static void main(String[] args) throws Exception {
		String propertyFileName = "application.properties";
		// Key portion of the properties the left hand side
		String userPwdKey = "database.user.password";
		// Key in the properties file that will tell us if the password is
		// already encrypted or not
		String isPwdEcnryptedKey = "is.database.user.password.encrypted";

		// Invoke the constrsuctor
		EncryptDecrypt app = new EncryptDecrypt(propertyFileName, userPwdKey,
				isPwdEcnryptedKey);

		// Retrieve the decrypted password
		String result = app.decryptedUserPassword;

		System.out.println("Decrypted password " + result);

		// Assert.assertTrue("Decrypted password should be \"myPassWord\"",
		// result.equalsIgnoreCase("myPassWord"));
	}
}