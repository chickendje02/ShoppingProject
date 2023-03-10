package com.excercise.customerservice.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@UtilityClass
public class MessageUtils {

    // Need to be 16 chars
    private static final String SECRET_KEY = "TrungNguyen06299";
    private static final String PARAMETER_SPEC = "TrungNguyen02295";

    public static String encrypt(String data) {
        try {
            IvParameterSpec iv = new IvParameterSpec(PARAMETER_SPEC.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encrypted = cipher.doFinal(data.getBytes());
            System.out.println("encrypted text: " + Base64.encodeBase64String(encrypted));
            return Base64.encodeBase64String(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
