package com.javatraining.corejavatraining.collections.coreInterface;

import java.util.*;

public class LinkedHashSetExample {

	public static void main(String[] args) {
		List<String> listData= Arrays.asList("One", "One", "Two", "Two", "Two", "Three", "Four", "Four", "Five",  null, "", "", null);
		LinkedHashSet<String> setData = new LinkedHashSet<>(listData);
		System.out.println(listData);
		System.out.println(setData);
		/*TreeSet<String> treeSet = new TreeSet<>(listData);
		System.out.println(treeSet);*/
	}
}
