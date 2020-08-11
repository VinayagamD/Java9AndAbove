/**
 * 
 */
package com.javatraining.corejavatraining.collections.coreInterface;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author vinay
 *
 */
public class DemoCustomIterator {

	public static void main(String[] args) {
		List<DemoData> demos = Arrays.asList(new DemoData("Demo1"), new DemoData("Demo2"), new DemoData("Demo3"), new DemoData("Demo"));
		DemoData[] demoArrays = demos.toArray(new DemoData[demos.size()]);
		SimpleList simpleList = new SimpleList(demoArrays);
		for(DemoData demoData: simpleList) {
			System.out.println(demoData.getName());
		}
	}

}
