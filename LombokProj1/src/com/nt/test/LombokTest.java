package com.nt.test;

import com.nt.model.Customer;

public class LombokTest {

	public static void main(String[] args) {
//		
//		Customer c1 = new Customer(101,"raja","hyd",677.78f);
//		Customer c2 = new Customer(101,"raja","hyd",677.78f);
//		System.out.println(c1.hashCode() + ", "+ c2.hashCode());
//		System.out.println(c1.equals(c2));
//		System.out.println(c1==c2);
		System.out.println(System.identityHashCode(1));
		System.out.println(System.identityHashCode(2));
	}

}
