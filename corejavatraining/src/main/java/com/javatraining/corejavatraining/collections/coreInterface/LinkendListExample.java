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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<String> datas = new LinkedList<String>();
		datas.add("One");
		datas.add("Two");
		datas.add("Three");
		
		System.out.println(datas);
		datas.addFirst("OneFirst");
		datas.addLast("Added Last");
		System.out.println(datas.peekFirst());
		System.out.println(datas);
		System.out.println(datas.pollFirst());
		System.out.println(datas);
		System.out.println(datas.peek());
		System.out.println(datas.poll());
		System.out.println(datas);
		datas.addFirst("OneFirst");
		Iterator<String> dataIterator = datas.descendingIterator();
		while(dataIterator.hasNext()) {
			System.out.println(dataIterator.next());
			
		}
		
		dataIterator = datas.iterator();
		
		while(dataIterator.hasNext()) {
			System.out.println(dataIterator.next());
		}
		datas.forEach(System.out::println);

		System.out.println(datas.stream().mapToInt(s -> s.length()).sum());
		System.out.println(datas.stream().filter(s -> s.length() > 6).mapToInt(s -> s.length()).sum());
		datas.stream().map(s -> s.toUpperCase()).collect(Collectors.toList()).forEach(System.out::println);
		datas.stream().map(String::toLowerCase).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println(datas.stream().collect(Collectors.groupingBy(s-> s)));

	}

}
