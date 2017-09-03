package br.com.exam.l7;
/**
 * A string S consisting of N characters is called properly nested if:
 * 
 * S is empty; S has the form "(U)" where U is a properly nested string; S has
 * the form "VW" where V and W are properly nested strings. For example, string
 * "(()(())())" is properly nested but string "())" isn't.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(String S); } that, given a string S
 * consisting of N characters, returns 1 if string S is properly nested and 0
 * otherwise.
 * 
 * For example, given S = "(()(())())", the function should return 1 and given S
 * = "())", the function should return 0, as explained above.
 * 
 * Assume that:
 * 
 * N is an integer within the range [0..1,000,000]; string S consists only of
 * the characters "(" and/or ")". Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(1) (not counting the storage required for input arguments).
 * 
 * @author A0061298
 *
 */

import java.lang.reflect.Method;
import java.util.Stack;
public class Nesting {
	
	private static void printResult(int expected, int result) {
		if (expected == result) {
			System.out.printf("TRUE : expected:%2d result:%2d", expected, result);
		} else {
			System.out.printf("FALSE: expected:%2d result:%2d", expected, result);
		}
		System.out.println("");
	}

	public static void main(String[] args) throws Exception {
		Nesting nof = new Nesting();
		Method met = nof.getClass().getMethod("solution", String.class);
		printResult(0, (int) met.invoke(nof, "()())"));
		printResult(1, (int) met.invoke(nof, "(()(())())"));
		printResult(0, (int) met.invoke(nof, "())"));
	}
	
	public int solution(String S) {
		if(S == null || S.isEmpty()){
			return 1;
		}
		char[] c = S.toCharArray();
		int length = c.length;
		if(length % 2 != 0){
			return 0;
		}
		Stack<Character> cs = new Stack<>();
		for(int i = 0; i < length; i++){
			if(cs.isEmpty() && c[i] == ')'){
				return 0;
			}
			if(c[i] == '('){
				cs.push('(');
			}else{
				cs.pop();
			}
		}
		return cs.isEmpty() ? 1 : 0;
	}
}
