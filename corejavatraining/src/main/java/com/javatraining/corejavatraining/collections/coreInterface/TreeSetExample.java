package com.javatraining.corejavatraining.collections.coreInterface;

import java.util.*;
import java.util.stream.Collectors;

public class TreeSetExample {

	public static void main(String[] args) {
		List<String> listData = Arrays.asList("One", "One", "Two", "Two", "Two", "Three", "Four", "Four", "Five", "", "", null);
		TreeSet<String> setData = new TreeSet<>(listData);
		System.out.println(listData);
		System.out.println(setData);
		TreeSet<String> treeSet = listData.stream().filter(Objects::nonNull).collect(Collectors.toCollection(TreeSet::new));
		System.out.println(treeSet);
	}
}
