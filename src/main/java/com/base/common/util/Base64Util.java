package com.base.common.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class Base64Util {

	/**
	 * TODO 覆盖方法encrypt简单说明 <br>
	 * 
	 * <pre>
	 * 覆盖方法encrypt详细说明 <br>
	 * &#64;
	 * &#64;date 2015-8-28 下午4:15:59
	 * </pre>
	 * 
	 * @param 参数类型
	 *            参数名 说明
	 * @return 返回值类型 说明
	 * @throws 异常类型
	 *             说明
	 * 
	 */
	public static String encrypt(String str) throws Exception {
		String result = null;
		try {
			result = new BASE64Encoder().encode(str.getBytes());
		} catch (Exception e) {
			throw new Exception(e);
		}
		return result;
	}

	/**
	 * TODO 覆盖方法decrypt简单说明 <br>
	 * 
	 * <pre>
	 * 覆盖方法decrypt详细说明 <br>
	 * &#64;
	 * &#64;date 2015-8-28 下午4:15:59
	 * </pre>
	 * 
	 * @param 参数类型
	 *            参数名 说明
	 * @return 返回值类型 说明
	 * @throws 异常类型
	 *             说明
	 * 
	 */
	public static String decrypt(String str) throws Exception {
		String result = null;
		try {
			// 前台BASE64将+处理为空格，后台将空格统一替换为+
			str = str.replaceAll(" ", "+");
			byte[] b = new BASE64Decoder().decodeBuffer(str);
			result = new String(b);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(encrypt("马云"));
		System.out.println(decrypt("6ams5LqR"));
	}
}
