package com.vinaylogics.corejavatraining.collections.basics;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TreeSetExample {

	public static void main(String[] args) {
		List<String> listData = Arrays.asList("One", "One", "Two", "Two", "Two", "Three", "Four", "Four", "Five", "", ""/*, null*/);
		TreeSet<String> setData = new TreeSet<>(listData);
		System.out.println(listData);
		System.out.println(setData);
		TreeSet<String> treeSet = listData.stream().filter(Objects::nonNull).collect(Collectors.toCollection(TreeSet::new));
		System.out.println(treeSet);
	}
}
