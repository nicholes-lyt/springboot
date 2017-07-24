package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestStr {
	public static void main(String[] args) {
		String id = "1,3,3";
		List<String> ids = new ArrayList<>();
		ids.add(id);
		ids.stream().distinct().collect(Collectors.toList());
		System.out.println(ids.stream().distinct().collect(Collectors.toList()));
	}
}	
