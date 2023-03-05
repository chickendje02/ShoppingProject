package com.excercise.cartservice.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MessageUtils {

    // Need to be 16 chars
    private static final String SECRET_KEY = "TrungNguyen06299";
    private static final String PARAMETER_SPEC = "TrungNguyen02295";

    public static String decrypt(String data) {
        try {
            IvParameterSpec iv = new IvParameterSpec(PARAMETER_SPEC.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] originalText = cipher.doFinal(Base64.decodeBase64(data));
            System.out.println("decrypted text: "  + new String(originalText));
            return new String(originalText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
