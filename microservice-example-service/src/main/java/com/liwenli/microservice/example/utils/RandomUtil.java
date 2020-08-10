package com.liwenli.microservice.example.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author
 * @describe 随机数工具类
 */
public class RandomUtil {
	public static final String NUMBERCHAR = "0123456789";
	public static final String LETTERCHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String NUMLETCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	// 随机数字字符
	public static String randomNumberString(int length) {
		StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i=0; i<length; i++) {
        	sb.append(NUMBERCHAR.charAt(random.nextInt(NUMBERCHAR.length())));
        }
        return sb.toString();
	}
	// 随机字母字符
	public static String randomLetterString(int length) {
		StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i=0; i<length; i++) {
        	sb.append(LETTERCHAR.charAt(random.nextInt(LETTERCHAR.length())));
        }
        return sb.toString();
	}
	// 随机数字字母
	public static String randomNumberLetter(int length) {
		StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i=0; i<length; i++) {
        	sb.append(NUMLETCHAR.charAt(random.nextInt(NUMLETCHAR.length())));
        }
        return sb.toString();
	}
	// 订单号
	public static String orderNumber() {
		// 12位
		String yyMMddHHmmss = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
		// 8位
		String randomNumber = RandomUtil.randomNumberString(8);
		return yyMMddHHmmss + randomNumber;
	}
	
	public static void main(String[] args) {
		String str = RandomUtil.randomNumberString(8);
		System.out.println(str);
		String uuid = RandomUtil.randomNumberLetter(32);
		System.out.println(uuid);
		
	}
}
