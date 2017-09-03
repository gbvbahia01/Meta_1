package br.com.exam.l9;

import java.lang.reflect.Method;

public class MaxDoubleSliceSum {

	private static void printResult(int expected, int result) {
		if (expected == result) {
			System.out.printf("TRUE : expected:%2d result:%2d", expected, result);
		} else {
			System.out.printf("FALSE: expected:%2d result:%2d", expected, result);
		}
		System.out.println("");
	}

	public static void main(String[] args) throws Exception {
		MaxDoubleSliceSum nof = new MaxDoubleSliceSum();
		Method met = nof.getClass().getMethod("solution", int[].class);
		printResult(17, (int) met.invoke(nof, new int[] { 3, 2, 6, -1, 4, 5, -1, 2 }));
		// printResult(5, (int) met.invoke(nof, new int[] { 3, 2, -6, 4, 0 }));
		// printResult(-2, (int) met.invoke(nof, new int[] { -3, -2, -100, -60,
		// -40 }));
		// printResult(3, (int) met.invoke(nof, new int[] { 3, -2, -40, -60,
		// -100 }));
	}

	/*
	 * We can use Kadane’s algorithm from two directions. First, we can safely
	 * ignore A[0] and A[N-1] since by definition they can’t be a part of any
	 * double-slice sum.
	 * 
	 * Now, define K1[i] as the maximum sum contiguous subsequence ending at
	 * index \(i\), and similarly, define K2[i] as the maximum sum contiguous
	 * subsequence starting with index \(i\).
	 * 
	 * Then, iterate over \(i\), and find the maximum sum of K1[i-1]+K2[i+1].
	 * This is the max double slice sum.
	 */
	public int solution(int[] A) {
		int N = A.length;
		int[] K1 = new int[N];
		int[] K2 = new int[N];
		//{ X, 2, 6, -1, 4, 5, -1, X }
		for (int i = 1; i < N - 1; i++) {
			K1[i] = Math.max(K1[i - 1] + A[i], 0);
		}//[0, 2, 8, 7, 11, 16, 15, 0]
		for (int i = N - 2; i > 0; i--) {
			K2[i] = Math.max(K2[i + 1] + A[i], 0);
		}//[0, 16, 14, 8, 9, 5, 0, 0]
		int max = 0;
		for (int i = 1; i < N - 1; i++) {
			max = Math.max(max, K1[i - 1] + K2[i + 1]);
		}
		return max;
	}

}
