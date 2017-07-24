package com.base.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @ClassName: MD5   
 * @Description: 字符串MD5加密,用于用户注册时候，用户密码加密处理。MD5无法解密
 * @author yuting.li
 * @version 1.0 
 * @date 2017年7月24日 上午10:58:26
 */
public class MD5 {
	private static Log logger = LogFactory.getLog(MD5.class);

	public static String getEncrypt(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(input.getBytes());
			byte[] bb = md.digest();
			String hs = "", tmp = "";
			for (byte e : bb) {
				tmp = (Integer.toHexString(e & 0xFF));
				hs = tmp.length() == 1 ? hs + "0" + tmp : hs + tmp;
			}
			return hs;
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage());
			return "";
		}
	}

	/**
	 * 
	 * 描述：32位md5加密 <br/>
	 * 作者：jing.zhao@rogrand.com <br/>
	 * 生成日期：2016-3-11 <br/>
	 * 
	 * @param s
	 *            带加密字符串
	 * @return
	 */
	public final static String MD532(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}