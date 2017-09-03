package br.com.exam.l8;

/**
 * A zero-indexed array A consisting of N integers is given. The dominator of
 * array A is the value that occurs in more than half of the elements of A.
 * 
 * For example, consider array A such that
 * 
 * A[0] = 3 A[1] = 4 A[2] = 3 A[3] = 2 A[4] = 3 A[5] = -1 A[6] = 3 A[7] = 3 The
 * dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in
 * those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 * 
 * Write a function
 * 
 * class Solution { public int solution(int[] A); } that, given a zero-indexed
 * array A consisting of N integers, returns index of any element of array A in
 * which the dominator of A occurs. The function should return −1 if array A
 * does not have a dominator.
 * 
 * Assume that:
 * 
 * N is an integer within the range [0..100,000]; each element of array A is an
 * integer within the range [−2,147,483,648..2,147,483,647]. For example, given
 * array A such that
 * 
 * A[0] = 3 A[1] = 4 A[2] = 3 A[3] = 2 A[4] = 3 A[5] = -1 A[6] = 3 A[7] = 3 the
 * function may return 0, 2, 4, 6 or 7, as explained above.
 * 
 * Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(1), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 * 
 * @author A0061298
 *
 */
import java.lang.reflect.Method;
import java.util.Stack;

public class Dominator {

	private static void printResult(int expected, int result) {
		if (expected == result) {
			System.out.printf("TRUE : expected:%2d result:%2d", expected, result);
		} else {
			System.out.printf("FALSE: expected:%2d result:%2d", expected, result);
		}
		System.out.println("");
	}

	public static void main(String[] args) throws Exception {
		Dominator nof = new Dominator();
		Method met = nof.getClass().getMethod("solution", int[].class);
		printResult(7, (int) met.invoke(nof, new int[] { 3, 4, 3, 2, 3, -1, 3, 3 }));
		printResult(-1, (int) met.invoke(nof, new int[] { 3, 4, 5, 2, 6, -1, 7, 3 }));
	}

	public int solution(int[] A) {
		int length = A == null ? -1 : A.length;
		if(length == -1 || length == 0){
			return -1;
		}
		if(length == 1){
			return 0;
		}
		Stack<int[]> leader = new Stack<>();
		for(int i = 0; i < length; i++){
			if(leader.isEmpty()){
				leader.push(new int[]{A[i], i});
			}else{
				if(leader.peek()[0] == A[i]){
					leader.push(new int[]{A[i], i});
				}else{
					leader.pop();
				}
			}
		}
		if(leader.isEmpty()){
			return -1;
		}
		int candidate = leader.peek()[0];
		int count = 0;
		for(int i = 0; i < length; i++){
			if(A[i] == candidate){
				count++;
			}
		}
		if(count > length /2)
			return leader.peek()[1];
		else
			return -1;
	}
}
