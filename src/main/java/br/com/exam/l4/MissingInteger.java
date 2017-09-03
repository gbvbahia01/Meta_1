package br.com.exam.l4;

/**
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); } that, given a non-empty
 * zero-indexed array A of N integers, returns the minimal positive integer
 * (greater than 0) that does not occur in A.
 * 
 * For example, given:
 * 
 * A[0] = 1 A[1] = 3 A[2] = 6 A[3] = 4 A[4] = 1 A[5] = 2 the function should
 * return 5.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [−2,147,483,648..2,147,483,647]. Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 * 
 * @author A0061298
 *
 */
import java.util.Arrays;
public class MissingInteger {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE}));
	}
	
	public static int solution(int[] A) {
		if(A.length == 1){
			return A[0] == 1 ? 2 : 1;
		}
		Arrays.sort(A);
		boolean oneFound = false;
		for(int i = 0; i < A.length - 1; i++){
			if(A[i] == 1){
				oneFound = true;
			}
			if(A[i] > 1 && !oneFound){
				return 1;
			}
			if(A[i] + 1 > 0 && A[i] + 1< A[i + 1] ){
				return A[i] + 1;
			}
		}
		return oneFound ? A[A.length - 1] + 1 : 1;
	}
}
