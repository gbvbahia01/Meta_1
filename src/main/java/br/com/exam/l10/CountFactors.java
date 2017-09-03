package br.com.exam.l10;

import java.lang.reflect.Method;

/**
 * A positive integer D is a factor of a positive integer N if there exists an
 * integer M such that N = D * M.
 * 
 * For example, 6 is a factor of 24, because M = 4 satisfies the above condition
 * (24 = 6 * 4).
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int N); } that, given a positive integer
 * N, returns the number of its factors.
 * 
 * For example, given N = 24, the function should return 8, because 24 has 8
 * factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..2,147,483,647]. Complexity:
 * 
 * expected worst-case time complexity is O(sqrt(N)); expected worst-case space
 * complexity is O(1).
 */
public class CountFactors {

	private static void printResult(int expected, int result) {
		if (expected == result) {
			System.out.printf("TRUE : expected:%2d result:%2d", expected, result);
		} else {
			System.out.printf("FALSE: expected:%2d result:%2d", expected, result);
		}
		System.out.println("");
	}

	public static void main(String[] args) throws Exception {
		CountFactors nof = new CountFactors();
		Method met = nof.getClass().getMethod("solution", int.class);
		printResult(8, (int) met.invoke(nof, 24));//1,2,3,4,6,8,12,24
		printResult(3, (int) met.invoke(nof, 25));//1,5,25
	}

	public int solution(int N) {
		if (N == 1) return 1;
		int i = 1;
		int factors = 0;
		for (; i < Math.sqrt(N); i++)
			if (N % i == 0)	
				factors += 2;		
		if(i * i == N)factors++;
		return factors;
	}
}
