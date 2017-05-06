package com.test;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
	
	public static void main(String[] args) {
		/*int code = 100000;
		for(int i= 1;i<10;i++){
			String str = code+i+"";
			str = "YP"+str.substring(1, str.length());
			System.out.println(str);
		}
		
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				
			}
		});*/
		
		String str = " MM'S花生牛奶巧克力 ";
		str = str.replaceAll("'", "");
		System.out.println(str);
		
		List<String> list = new ArrayList<String>();
		list.forEach(s -> {System.out.println(s);});
		
		new Thread(()->{System.out.println("lambda启动线程-----");}).start();
	}

}
