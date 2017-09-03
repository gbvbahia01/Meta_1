package br.com.exam.l7;

/**
 * A string S consisting of N characters is considered to be properly nested if
 * any of the following conditions is true:
 * 
 * S is empty; S has the form "(U)" or "[U]" or "{U}" where U is a properly
 * nested string; S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(String S); } that, given a string S
 * consisting of N characters, returns 1 if S is properly nested and 0
 * otherwise.
 * 
 * For example, given S = "{[()()]}", the function should return 1 and given S =
 * "([)()]", the function should return 0, as explained above.
 * 
 * Assume that:
 * 
 * N is an integer within the range [0..200,000]; string S consists only of the
 * following characters: "(", "{", "[", "]", "}" and/or ")". Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(N) (not counting the storage required for input arguments).
 * 
 * @author A0061298
 *
 */
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Brackets {

	private static void printResult(int expected, int result) {
		if (expected == result) {
			System.out.printf("TRUE : expected:%2d result:%2d", expected, result);
		} else {
			System.out.printf("FALSE: expected:%2d result:%2d", expected, result);
		}
		System.out.println("");
	}

	public static void main(String[] args) throws Exception {
		Brackets nof = new Brackets();
		Method met = nof.getClass().getMethod("solution", String.class);
		printResult(0, (int) met.invoke(nof, "{{{{"));// 0
		printResult(1, (int) met.invoke(nof, "({{({}[]{})}}[]{})"));// 1
		printResult(0, (int) met.invoke(nof, "())(()"));// 0
		printResult(0, (int) met.invoke(nof, "[()}"));// 0
		printResult(0, (int) met.invoke(nof, "))(("));// 0
		printResult(1, (int) met.invoke(nof, "{[()()]}"));// 1
		printResult(0, (int) met.invoke(nof, "([)()]"));// 0
	}

	private static final Map<Character, Character> BRACES = new HashMap<>();
	static {
		BRACES.put('(', ')');
		BRACES.put('{', '}');
		BRACES.put('[', ']');
	}

	public int solution(String S) {
		if (S == null || S.isEmpty()) {
			return 1;
		}
		int length = S.length();
		if (length % 2 != 0) {
			return 0;
		}
		return evaluate(S) ? 1 : 0;
	}

	private boolean evaluate(String s) {
		Stack<Character> st = new Stack<>();
		Set<Character> keys = BRACES.keySet();
		char[] c = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			for(Character key : keys){
				if(key.equals(c[i])){
					st.push(key);
					break;
				}else if(BRACES.get(key).equals(c[i])){
					if(st.isEmpty()){
						return false;
					}
					Character chk = st.pop();
					if(!chk.equals(key)){
						return false;
					}
					break;
				}
			}
		}
		return st.isEmpty();
	}
}
