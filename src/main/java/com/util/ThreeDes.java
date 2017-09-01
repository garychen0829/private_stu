package com.util;

/**
 * Created by dev1 on 2016/7/8.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.spec.KeySpec;


public class ThreeDes {
    private static Logger logger = LoggerFactory.getLogger(ThreeDes.class);

    static String TriDes = "DESede/ECB/NoPadding";
    public static byte[] trides_crypt(byte key[], byte data[]) {
        try {
            byte[] k = new byte[24];

            int len = data.length;
            if (data.length % 8 != 0) {
                len = data.length - data.length % 8 + 8;
            }
            byte[] needData = null;
            if (len != 0)
                needData = new byte[len];

            for (int i = 0; i < len; i++) {
                needData[i] = 0x00;
            }

            System.arraycopy(data, 0, needData, 0, data.length);

            if (key.length == 16) {
                System.arraycopy(key, 0, k, 0, key.length);
                System.arraycopy(key, 0, k, 16, 8);
            } else {
                System.arraycopy(key, 0, k, 0, 24);
            }

            KeySpec ks = new DESedeKeySpec(k);
            SecretKeyFactory kf = SecretKeyFactory.getInstance("DESede");
            SecretKey ky = kf.generateSecret(ks);

            Cipher c = Cipher.getInstance(TriDes);
            c.init(Cipher.ENCRYPT_MODE, ky);
            return c.doFinal(needData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static byte[] trides_decrypt(byte key[], byte data[]) {
        try {
            byte[] k = new byte[24];

            int len = data.length;
            if (data.length % 8 != 0) {
                len = data.length - data.length % 8 + 8;
            }
            byte[] needData = null;
            if (len != 0)
                needData = new byte[len];

            for (int i = 0; i < len; i++) {
                needData[i] = 0x00;
            }

            System.arraycopy(data, 0, needData, 0, data.length);

            if (key.length == 16) {
                System.arraycopy(key, 0, k, 0, key.length);
                System.arraycopy(key, 0, k, 16, 8);
            } else {
                System.arraycopy(key, 0, k, 0, 24);
            }
            KeySpec ks = new DESedeKeySpec(k);
            SecretKeyFactory kf = SecretKeyFactory.getInstance("DESede");
            SecretKey ky = kf.generateSecret(ks);

            Cipher c = Cipher.getInstance(TriDes);
            c.init(Cipher.DECRYPT_MODE, ky);
            return c.doFinal(needData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String encode2(String cardNo,String pwd) {
        char[] cardNoArray = cardNo.toCharArray();
        char[] pwdArray = pwd.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cardNoArray.length; i++){
            System.out.print(cardNoArray[i]+"    "+pwdArray[i]);
            int j = (Integer.parseInt(cardNoArray[i]+"", 16) ^ Integer.parseInt(pwdArray[i]+"", 16)) & 0xf;
            sb.append(Integer.toHexString(j));

        }
        logger.debug("       "+sb.toString());
        return sb.toString();
    }
    public static byte[] encData(String cardNo,String password,String des3key) {
//        logger.debug("cardNo:{}", cardNo);
//        logger.debug("password:{}", password);
//        logger.debug("des3key:{}", des3key);
        byte k16[] = hexToBytes(des3key);
        String pwd = "06"+password+"FFFFFFFF";
        int endindex = cardNo.length()-1;
        int startindex = endindex - 12;
        cardNo = "0000"+cardNo.substring(startindex,endindex);
        String enc = encode2(cardNo,pwd);
        byte data[] = hexToBytes(enc);

        byte result[] = trides_crypt(k16, data);

        logger.debug("pwd:{}"+byte2hex(result));

        logger.debug("Result = " + result.length);
        return result;
    }

    public static String byte2hex(byte[] data) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            String temp = Integer.toHexString(((int) data[i]) & 0xFF);
            for (int t = temp.length(); t < 2; t++) {
                sb.append("0");
            }
            sb.append(temp);
        }
        return sb.toString();
    }

    public static byte[] hexToBytes(String str) {
        if (str == null) {
            return null;
        } else if (str.length() < 2) {
            return null;
        } else {
            int len = str.length() / 2;
            byte[] buffer = new byte[len];
            for (int i = 0; i < len; i++) {
                buffer[i] = (byte) Integer.parseInt(
                        str.substring(i * 2, i * 2 + 2), 16);
            }
            return buffer;
        }
    }
}