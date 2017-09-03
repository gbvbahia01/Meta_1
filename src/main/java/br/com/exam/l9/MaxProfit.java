package br.com.exam.l9;

import java.lang.reflect.Method;

public class MaxProfit {

	private static void printResult(int expected, int result) {
		if (expected == result) {
			System.out.printf("TRUE : expected:%2d result:%2d", expected, result);
		} else {
			System.out.printf("FALSE: expected:%2d result:%2d", expected, result);
		}
		System.out.println("");
	}

	public static void main(String[] args) throws Exception {
		MaxProfit nof = new MaxProfit();
		Method met = nof.getClass().getMethod("solution", int[].class);
		 printResult(356, (int) met.invoke(nof, new int[] { 23171, 21011, 21123, 21366, 21013, 21367 }));
		 printResult(0, (int) met.invoke(nof, new int[] { 5, 4, 3, 2, 1 }));
		printResult(24, (int) met.invoke(nof, new int[] { 11, 10, 30, 5, 12, 25, 29 }));
	}

	/**
	 * N is an integer within the range [0..400,000]; each element of array A is
	 * an integer within the range [0..200,000].
	 * 
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		if (A == null || A.length < 2) {
			return 0;
		}
		int profit = 0;
		int minPrice = A[0];
		for (int i = 1; i < A.length; i++) {
			profit = Math.max(profit, A[i] - minPrice);
			minPrice = Math.min(minPrice, A[i]);
		}
		return profit;
	}

	public int solution3(int[] A) {
		if (A == null || A.length <= 1)	return 0;
		int minBuyingPrice = A[0];
		int maxProfitSoFar = 0;
		for (int i = 1; i < A.length; i++) {
			maxProfitSoFar = Math.max(maxProfitSoFar, A[i] - minBuyingPrice);
			minBuyingPrice = Math.min(minBuyingPrice, A[i]);
		}
		return maxProfitSoFar;
	}
	
	public int solution2(int[] A) {
		if (A.length == 1 || A.length == 0) {
			return 0;
		}
		int maxSoFar = 0;
		int maxEndingHere = 0;
		int minPrice = A[0];
		for (int i = 1; i < A.length; i++) {
			maxEndingHere = Math.max(0, A[i] - minPrice);
			minPrice = Math.min(minPrice, A[i]);
			maxSoFar = Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}

}
