package com.javatraining.corejavatraining.collections.coreInterface;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
	public static void main(String[] args) {
		Map<String, Integer> maps = new HashMap<>();
		maps.put("One", 1);
		maps.put("One", 2);
		maps.put("two", 1);
		maps.put("Three", 2);
		maps.put(null, 2);
		maps.put(null, null);
		maps.put("Four", null);
		System.out.println(maps);
		System.out.println("Entry Set =================>");
		System.out.println("=============== Before java 8 =====================");
		for (Map.Entry<String,Integer> entry: maps.entrySet()){
			System.out.println("Key = "+entry.getKey() +" : value= "+entry.getValue());
		}
		System.out.println("=============== After java 8 =====================");
		maps.forEach((key, value) -> System.out.println(key + " => " + value));
		maps.keySet().forEach(System.out::println);
		maps.values().forEach(System.out::println);

		System.out.println(maps.containsKey(null));
		System.out.println(maps.containsKey("NoKey"));
		System.out.println(maps.get(null));
//		System.out.println(maps.get("NoKey"));
		System.out.println(maps.keySet());
		System.out.println(maps.values());
	}

}
