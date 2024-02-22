package com.binson.forEach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ForEachExample {
	public static void main(String[] args) {
		
		List<Integer> intLst = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) {
			intLst.add(i);
		}
		
		intLst.forEach(data->{
			System.out.println(data);
		});
		
	}
}
