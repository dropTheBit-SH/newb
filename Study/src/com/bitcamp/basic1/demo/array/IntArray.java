package com.bit.demo.array;

import java.util.Arrays;

public class IntArray {

	/**
	 * 
	 * @param arr
	 * @param length
	 * @return ?���?
	 */
	public double mean(int[] arr, int length) {
		int total = 0;
		for (int i = 0; i < length; i++) {
			total = total + arr[i];
		}
		return total / length;
	}

	/**
	 * 
	 * @param arr
	 * @return 배열 ?��?�� �? 최�?값의 번호
	 */
	public int maxIndex(int[] arr, int length) {
		int maxIndex = 0;
		for (int i = 1; i < length; i++) {
			if (arr[i] > arr[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	/**
	 * 
	 * @param arr
	 * @param length
	 * @return 배열 ?��?�� �? 최�?�?
	 */
	public int max(int[] arr, int length) {
		int maxIndex = maxIndex(arr, length);
		return arr[maxIndex];
	}

	/**
	 * 
	 * @param arr
	 * @param length
	 * @return 배열 ?��?�� �? 최소�?
	 */
	public int min(int[] arr, int length) {
		int minIndex = 0;
		for (int i = 1; i < length; i++) {
			if (arr[i] < arr[minIndex]) {
				minIndex = i;
			}
		}
		return arr[minIndex];
	}

	/**
	 * 
	 * @param arr
	 * @param length
	 * @return 중간�?
	 */
	public int median(int[] arr, int length) {
		int[] arrClone = new int[length];
		System.arraycopy(arr, 0, arrClone, 0, length);
		Arrays.sort(arrClone);
		return arrClone[(int) (Math.round(length / 2.0) - 1)];
	}

	/**
	 * 
	 * @param arr
	 * @param length
	 * @return ?���? ?��곱들?�� ?��
	 */
	public double variance(int[] arr, int length) { 
		double totalDev = 0; 
		double mean = mean(arr,length);
		for (int i = 0; i < length; i++) { 
			totalDev += Math.pow(mean - arr[i],2); 
		} 
		// Sample estimate of variance so divide by n-1. 
		return totalDev / (length - 1); 
	}

	/**
	 * 
	 * @param arr
	 * @param length
	 * @return 배열?�� ?���??���?
	 */
	public double stdDev(int[] arr, int length) { 
		return Math.sqrt(variance(arr, length)); 
	}
}