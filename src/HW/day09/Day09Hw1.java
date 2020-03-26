package day09;

import java.util.Arrays;

class Test {

	public void printArr(int[][] tmp){
		System.out.println(Arrays.toString(tmp[0]));
		System.out.println(Arrays.toString(tmp[1]));
	}
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
	
	public int[][] mkArr(int[] arr1, int[] arr2){
		int[][]tmp = new int[2][];
		tmp[0] = new int[arr1.length];
		tmp[1] = new int[arr2.length];
		
		for(int i=0; i<arr1.length; i++){
			tmp[0][i] = arr1[i];
		}
		for(int i=0; i<arr2.length; i++){
			tmp[1][i] = arr2[i];
		}
		return tmp;
	}
}

public class Day09Hw1 {
	public static void main(String[] args) {
		int[] arr1 = {10,20,30,40,50};
		int[] arr2 = {60,70,80};
		
		Test test = new Test();
//		test.printArr(arr);
	
		int[] arr3 = test.joinArr(arr1, arr2); 
		test.printArr(arr3);
	
		int[][] arr4 = test.mkArr(arr1, arr2);
		test.printArr(arr4); 
	}
}




