package com.javatraining.corejavatraining.package_hierachy;

public class ObjectMethodsDemo {

	@Override
	public int hashCode() {
		return 64;
	}

	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}

	@Override
	public String toString() {
		return String.valueOf(hashCode());
	}

	public static void main(String[] args) {
		ObjectMethodsDemo omd = new ObjectMethodsDemo();
		ObjectMethodsDemo omd1 = new ObjectMethodsDemo();
		System.out.println(omd);
		System.out.println(omd1);
		System.out.println(omd.hashCode() == omd1.hashCode());
		System.out.println(omd.equals(omd1));
		System.out.println(omd.getClass().getSimpleName());
		System.out.println(omd.getClass().getCanonicalName());
		System.out.println(omd.getClass().getName());
		System.out.println(omd.getClass().getAnnotatedSuperclass());
	}

}
