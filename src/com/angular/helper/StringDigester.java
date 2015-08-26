package com.angular.helper;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringDigester {

   public static String digestString(String value) {
      String encryptedValue = "";

      if (value == null || value.equals("")) {
         return encryptedValue;
      }

      // Removing trailing spaces
      value = value.trim();

      try {
         MessageDigest messageDigest;
         messageDigest = MessageDigest.getInstance("MD5");

         messageDigest.reset();
         messageDigest.update(value.getBytes());

         byte[] digest = messageDigest.digest();
         BigInteger bigInt = new BigInteger(1, digest);
         encryptedValue = bigInt.toString(16);

         // Now we need to zero pad it if you actually want the full 32
         // chars.
         while (encryptedValue.length() < 32) {
            encryptedValue = "0" + encryptedValue;
         }
      }
      catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
      }
      return encryptedValue;
   }

}
