package book;

import java.util.*;

public class Chapter3 {


import java.util.*;

public class Chapter3 {
	static Scanner scan = new Scanner(System.in);
	static int input = 0;
	static String inputS = "";
	public static void main(String[] args) {
//		ch3_1_1();
//		ch3_1_2();
//		ch3_1_3();
//		ch3_2();
//		ch3_3();
//		ch3_4();
//		ch3_5();
//		ch3_6();
//		ch3_7();
		ch3_8();
	}
	public static void ch3_8() {
		System.out.print("정수 몇개(100미만)?");
		input = scan.nextInt();
		int[] ranNum = new int[input];
		for(int i=0; i<ranNum.length; i++) {
			ranNum[i] = (int)(Math.random()*100+1);
			for(int j=0; j<i; j++) {
				if(i!=0 && (ranNum[i] == ranNum[j])){
                                       i--;
                                }
                           

			}
		
	}	
		for(int i=0; i<ranNum.length; i++){
					System.out.print(ranNum[i]+"\n");
	}
		
		
	}
	public static void ch3_7() {
		int sum = 0;
		int[] ranNum = new int[10];
		
		System.out.print("랜덤한 정수들: ");
		for(int i=0; i<ranNum.length; i++) {
			ranNum[i] = (int)(Math.random()*10+1);
			System.out.print(ranNum[i]+" ");
			sum += ranNum[i];
		}
		System.out.println("\n평균은 "+(double)sum/ranNum.length);
	}
	public static void ch3_6() {
		System.out.print("금액을 입력하시오>>");
		input = scan.nextInt();
		int[] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};
		int[] result = new int[unit.length];
		for(int i=0; i<unit.length; i++) {
			if(input>unit[i]) {
				result[i] = input / unit[i];
				input -= result[i] * unit[i];
				System.out.println(unit[i]+"원 짜리 : "+result[i]+"개");
			}
		}
	}
	public static void ch3_5() {
		System.out.print("양의 정수를 10개 입력하시오>>");
		int[] arr = new int[10];
		for(int i=0; i<arr.length; i++) {
			arr[i]=scan.nextInt();
		}
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%3==0 && arr[i]!=0)
				System.out.println(arr[i]);
		}

	}
	
	public static void ch3_4() {
		System.out.print("소문자 알파벳 하나를 입력하시오>>");
		inputS = scan.next();
		char c = inputS.charAt(0);
		char[] alphabetArr = {'a','b','c','d','e'}; 
		int count = 0;
		for(int i=0; i<alphabetArr.length; i++) {
			if(c==alphabetArr[i]) {
				count = i+1;
			}
		}
		for(int i=0; i<count; i++) {
			for(int j=0; j<count-i; j++) {
				System.out.print(alphabetArr[j]);
			}
			System.out.println();
		}
		
	}
	
	public static void ch3_3() {
		System.out.print("정수를 입력하시오>>");
		input = scan.nextInt();
		for(int i=0; i<input; i++) {
			for(int j=input-i; j>0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void ch3_2() {
		int n[][]= {{1},{1,2,3},{1},{1,2,3,4},{1,2}};
		for(int i=0; i<n.length; i++) {
			for(int j=0; j<n[i].length; j++) {
				System.out.print(n[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void ch3_1_3() {
		int sum = 0, i = 0;
		do {
			sum+=i;
			i+=2;
		}while(i<100);
		System.out.println(sum);
	}
	public static void ch3_1_2() {
		int sum = 0;
		for(int i=0; i<100; i+=2) {
			sum+=i;
		}
		System.out.println(sum);
	}
	public static void ch3_1_1() {
		int sum = 0, i = 0;
		while(i<100) {
			sum+=i;
			i+=2;
		}
		System.out.println(sum);
		
	}
}
