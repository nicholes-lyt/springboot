package com.base.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成类似hibernate中uuid 32位主键序列
 * 
 * @version: V1.0
 */
public class UUIDGenerator extends Thread {

    private static long orderNum = 0l;

    private static String date;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            System.out.println(UUIDGenerator.getOrderNo());
            // Thread.sleep(1000);
        }
    }

    /**
     * 生成订单编号
     * 
     * @return
     */
    public static synchronized String getOrderNo() {
        String str = new SimpleDateFormat("yyMMddHHmm").format(new Date());
        if (date == null || !date.equals(str)) {
            date = str;
            orderNum = 0l;
        }
        orderNum++;
        long orderNo = Long.parseLong((date)) * 10000;
        orderNo += orderNum;
        return orderNo + "";
    }
}