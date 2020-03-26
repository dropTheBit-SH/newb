package day09;

import java.util.Arrays;

class Test {

	public void printArr(int[] tmp){
		System.out.println(Arrays.toString(tmp));
	}
	
	public int[] joinArr(int[] arr1, int[] arr2) {
		int[]tmp = new int[arr1.length+arr2.length];
		for(int i=0; i<tmp.length; i++){
			tmp[i] = i<arr1.length? arr1[i] : arr2[i-arr1.length];
		}
		return tmp;
	}
}

public class Day09Hw1 {
	public static void main(String[] args) {
		int[] arr1 = {10,20,30,40,50};
		int[] arr2 = {60,70,80};
		
		Test test = new Test();

		int[] arr3 = test.joinArr(arr1, arr2); 
		test.printArr(arr3);
	
	}
}




