package com.binson.map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapStreamExample {
	
	public static void main(String[] args) {
		List<Integer> intLst = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) {
			intLst.add(i);
		}
		
		intLst.stream().map().distinct().collect(Collectors.toList());
	}
}
