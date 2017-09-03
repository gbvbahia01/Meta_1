package br.com.exam.l7;

import java.lang.reflect.Method;
import java.util.Stack;

public class StoneWall {

	private static void printResult(int expected, int result) {
		if (expected == result) {
			System.out.printf("TRUE : expected:%2d result:%2d", expected, result);
		} else {
			System.out.printf("FALSE: expected:%2d result:%2d", expected, result);
		}
		System.out.println("");
	}

	public static void main(String[] args) throws Exception {
		StoneWall nof = new StoneWall();
		Method met = nof.getClass().getMethod("solution", int[].class);
		printResult(3, (int) met.invoke(nof, new int[] { 1, 2, 3, 3, 2, 1 }));
		printResult(3, (int) met.invoke(nof, new int[] { 3, 2, 1 }));
		printResult(7, (int) met.invoke(nof, new int[] { 8, 8, 5, 7, 9, 8, 7, 4, 8 }));
		printResult(3, (int) met.invoke(nof, new int[] { 2, 1, 1, 1, 3, 1 }));
		printResult(1, (int) met.invoke(nof, new int[] { 1, 1, 1, 1, 1, 1 }));

	}

	/**
	 * N is an integer within the range [1..100,000]; each element of array H is
	 * an integer within the range [1..1,000,000,000].
	 * 
	 * @param H
	 * @return
	 */
	public int solution(int[] H) {
		Stack<Integer> stack = new Stack<Integer>();
		int count = 0;
		for (int i = 0; i < H.length; i++) {
			if (stack.size() == 0) {
				count++;
				stack.push(H[i]);
			} else {
				if (stack.peek() > H[i]) {
					while (!stack.isEmpty() && stack.peek() > H[i]) {
						stack.pop();
					}
					i--;
				} else if (stack.peek() < H[i]) {
					count++;
					stack.push(H[i]);
				}
			}
		}
		return count;
	}
}
