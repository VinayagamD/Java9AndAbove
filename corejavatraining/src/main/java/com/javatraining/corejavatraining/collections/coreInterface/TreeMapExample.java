package com.javatraining.corejavatraining.collections.coreInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
	public static void main(String[] args) {
		TreeMap<String, Integer> maps = new TreeMap<>();
		maps.put("One", 1);
		maps.put("One", 2);
		maps.put("two", 1);
		maps.put("Three", 2);
//		maps.put(null, 2);
//		maps.put(null, null);
		maps.put("Four", null);
		System.out.println(maps);
		System.out.println("Entry Set =================>");
		maps.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " => " +entry.getValue());
			
		});
		maps.keySet().forEach(System.out::println);
		maps.values().forEach(System.out::println);

//		System.out.println(maps.containsKey(null));
		System.out.println(maps.containsKey("NoKey"));
		System.out.println(maps.keySet());
		System.out.println(maps.values());
		
	}

}
