package com.bit;

public class gogo {

	public static void main(String[] args) {
		A a = new A();
		a.setAnum(3);
		B b = new B();
		b.todo(new A(a));
		
		System.out.println(a.getAnum());

	}

}
