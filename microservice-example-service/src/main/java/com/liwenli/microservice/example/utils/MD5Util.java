package com.liwenli.microservice.example.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @author
 * @describe 加密算法（MD5）工具类
 */
public class MD5Util {

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
            'e', 'f'};

    private MD5Util() {

    }

    public static String getEncryption(String originString)
            throws UnsupportedEncodingException {
        String result = "";
        if (originString != null) {
            try {
                // 指定加密的方式为MD5
                MessageDigest md = MessageDigest.getInstance("MD5");
                // 进行加密运算
                byte bytes[] = md.digest(originString.getBytes("ISO8859-1"));
                for (int i = 0; i < bytes.length; i++) {
                    // 将整数转换成十六进制形式的字符串 这里与0xff进行与运算的原因是保证转换结果为32位
                    String str = Integer.toHexString(bytes[i] & 0xFF);
                    if (str.length() == 1) {
                        str += "F";
                    }
                    result += str;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String md5(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        messageDigest.update(str.getBytes());
        return byteArray2HexString(messageDigest.digest());
    }

    /**
     * MD5加密结果（由byte转换成String）
     *
     * @param bytes md5加密后得到的数组
     * @return md5加密结果
     * @author sucb
     * @date 2017年7月26日下午5:12:09
     */
    private static String byteArray2HexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(HEX_DIGITS[(b & 0xf0) >> 4]).append(HEX_DIGITS[(b & 0x0f)]);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] usernameChar = "zhangsan".getBytes();
        String key = "javaguo0628.";
        byte[] letter = key.getBytes();
        String token = System.currentTimeMillis() + "";
        Random random = new Random();
        for (int i = 0; i < usernameChar.length; i++) {
            token += usernameChar[i] + letter[(random.nextInt(11) + 1)] + random.nextInt(100);
        }
        token = MD5Util.getEncryption(token);
        System.out.println(token);
    }

}