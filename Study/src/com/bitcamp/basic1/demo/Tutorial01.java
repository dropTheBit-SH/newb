package com.bit.demo;

import java.util.Scanner;

/*
 * ~ ?��?��?��.
 * ?��?��. ?���? 계산?���?
 * ?��?��. 주차?��?�� 주차?�� ?��간을 계산?��?�� ?��금을 받는 ?��로그?��
 * ?��구사?��
 * 	1. 기본?���? : 5000?��
 * 	2. 10분당 : 500?�� �??��
 * 	3. 콘솔 ?��출력 ?��경에?�� ?��?��
 */
public class Tutorial01 {
	static Scanner sc = new Scanner(System.in);
// static ?��?��
	public static void main(String[] args) {

		// ?��?��?�� ?���? ?��?�� : ?��:�? 0000
		int in = getTime();
		// ?���??�� ?���? ?��?��
		int out = getTime();
		// ?���? �? 구하�?
		int diff = diffTime(in,out);
		// ?���? 계산?���?
		double price = getPrice(diff);
		
		System.out.println("price :" + price);
	}
	
	static int getTime(){
		int t = 0;
		t = sc.nextInt();
		return t;
	}
	
	static int diffTime(int in, int out){
		return out - in;
	}
	
	static double getPrice(int diff){
		double price = 0.0;
		return price;
	}
	

}
