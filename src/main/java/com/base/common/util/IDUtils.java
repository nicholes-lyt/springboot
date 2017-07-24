package com.base.common.util;

import java.util.UUID;

/**
 * 
 * @ClassName: IDUtils   
 * @Description: Uid
 * @author yuting.li
 * @version 1.0 
 * @date 2017年7月24日 上午11:16:50
 */
public final class IDUtils {
	
	private IDUtils(){}

    public static String genUUIDAsStr() {
        return UUID.randomUUID().toString();
    }

    public static String genUUIDAsShortStr() {
        return genUUIDAsStr().replaceAll("-", "");
    }
    
    public static void main(String[] args) {
		System.out.println(genUUIDAsShortStr());
	}

}
