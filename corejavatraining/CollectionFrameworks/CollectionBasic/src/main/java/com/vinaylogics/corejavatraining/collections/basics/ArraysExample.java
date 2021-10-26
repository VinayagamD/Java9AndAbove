/**
 * 
 */
package com.vinaylogics.corejavatraining.collections.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author vinay
 *
 */
public class ArraysExample {
	

	static Consumer<String> drinkConsumer = (String drink) -> System.out.println(drink);
	static Predicate<String> drinkPredicate = (String drink) -> drink.contains("Tea");
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String [] arrays = new String[5];
		arrays[0] = "Honey";
		arrays[1] = "Pepper";
		arrays[2] = "Tulsi";
		arrays[3] = "Green Tea";
		arrays[4] = "Lemon Tea";
		
		List<String> hotDrinks =new ArrayList<>( Arrays.asList(arrays[0],arrays[1],arrays[2], arrays[3],arrays[4] ));
		hotDrinks.add("Tulsi Green");
		// () -> {}
		// if else if
		// Switch case
		
		/*
		 * for (int i = 0; i < arrays.length; i++) { System.out.println(arrays[i]); }
		 * 
		 * for (String string : arrays) { System.out.println(string); }
		 */
		
		/*
		 * hotDrinks.forEach(hotDrink -> { System.out.println(hotDrink); });
		 */
//		hotDrinks.forEach(System.out::println);
		
//		hotDrinks.forEach(drinkConsumer);
		
//		List<String> drinksFiltered = hotDrinks.stream().filter(drinkPredicate).collect(Collectors.toList());
//		drinksFiltered.forEach(drinkConsumer);
		Iterator<String> drinkIterator = hotDrinks.iterator();
		while (drinkIterator.hasNext()) {
			System.out.println(drinkIterator.next());
			
		}
		
		for(Iterator<String> name = hotDrinks.iterator(); name.hasNext();) {
			String nextName = name.next();
			System.out.println(nextName);
			name.remove();
		}
		
		
		
		
	}

}
