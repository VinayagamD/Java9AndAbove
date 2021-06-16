/**
 * 
 */
package com.javatraining.corejavatraining.collections.coreInterface;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @author vinay
 *
 */
public class LinkendListExample {

	public static void main(String[] args) {
		LinkedList<String> datas = new LinkedList<>();
		datas.add("One");
		datas.add("Two");
		datas.add("Three");
		
		System.out.println(datas);
		datas.addFirst("OneFirst");// pn dn nn
		datas.addLast("Added Last");
		datas.addLast("Added Last");
		datas.addLast("Added Last");
		System.out.println(datas.peekFirst());
		System.out.println(datas);
		System.out.println(datas.pollFirst());
		System.out.println(datas);
		System.out.println(datas.peekLast());
		System.out.println(datas);
		System.out.println(datas.pollLast());
		System.out.println(datas);
		datas.addFirst("OneFirst");
		datas.addFirst("OneFirst");

		System.out.println();
		System.out.println("========================= Descending Iterator ==============");
		Iterator<String> dataIterator = datas.descendingIterator();
		while(dataIterator.hasNext()) {
			System.out.println(dataIterator.next());
		}

		System.out.println();
		System.out.println("============================ Ascending Iterator ==================");
		dataIterator = datas.iterator();
		
		while(dataIterator.hasNext()) {
			System.out.println(dataIterator.next());
		}
		System.out.println();

		datas.forEach(System.out::println);
		datas.forEach(d -> System.out.println(d));


		System.out.println("=========== Java 8 ==========================");
		System.out.println("MAP");
		System.out.println(datas.stream().mapToInt(s -> s.length()).sum());
		System.out.println("========= Filtered Map =================");
		System.out.println(datas.stream().filter(s -> s.length() > 6).mapToInt(s -> s.length()).sum());

		System.out.println();
		datas.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);

		System.out.println();
		datas.stream().map(String::toLowerCase).collect(Collectors.toList()).forEach(System.out::println);

		System.out.println();
		System.out.println(datas.stream().collect(Collectors.groupingBy(s-> s)));
	}

}
