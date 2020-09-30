package com.javatraining.corejavatraining.collections.coreInterface;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetExample {

	public static void main(String[] args) {
		List<String> listData= Arrays.asList("One", "One", "Two", "Two", "Two", "Three", "Four", "Four", "Five",  null, "", "", null);
		Set<String> setData = new HashSet<>(listData);
		System.out.println(listData);
		System.out.println(setData);
		setData.remove("Two");
		System.out.println(setData);
	}
}
