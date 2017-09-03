package br.com.exam.l10;

import java.lang.reflect.Method;

public class MinPerimeterRectangle {

	private static void printResult(int expected, int result) {
		if (expected == result) {
			System.out.printf("TRUE : expected:%2d result:%2d", expected, result);
		} else {
			System.out.printf("FALSE: expected:%2d result:%2d", expected, result);
		}
		System.out.println("");
	}

	public static void main(String[] args) throws Exception {
		MinPerimeterRectangle nof = new MinPerimeterRectangle();
		Method met = nof.getClass().getMethod("solution", int.class);
		printResult(22, (int) met.invoke(nof, 30));
		printResult(126500, (int) met.invoke(nof, 1000000000));

	}

	public int solution(int N) {
		int i = 1;
		int perimeter = Integer.MAX_VALUE;
		for (; i < Math.sqrt(N); i++) {
			if (N % i == 0) {
				perimeter = Math.min(perimeter, 2 * (N/i + i) );
			}
		}
		if (i * i == N){
			perimeter = Math.min(perimeter, 2 * (i + i));
		}
		
		return perimeter == Integer.MAX_VALUE ? 0 : perimeter;

	}
}
