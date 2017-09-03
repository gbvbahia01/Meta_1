package br.com.exam.l9;

/**
A non-empty zero-indexed array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A.
The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].
Write a function:
class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers, returns the maximum sum of any slice of A.
For example, given array A such that:
A[0] = 3  A[1] = 2  A[2] = -6
A[3] = 4  A[4] = 0
the function should return 5 because:
(3, 4) is a slice of A that has sum 4,
(2, 2) is a slice of A that has sum −6,
(0, 1) is a slice of A that has sum 5,
no other slice of A has sum greater than (0, 1).
Assume that:

N is an integer within the range [1..1,000,000];
each element of array A is an integer within the range [−1,000,000..1,000,000];
the result will be an integer within the range [−2,147,483,648..2,147,483,647].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 */
import java.lang.reflect.Method;
import java.util.Arrays;

public class MaxSliceSum {

	private static void printResult(int expected, int result) {
		if (expected == result) {
			System.out.printf("TRUE : expected:%2d result:%2d", expected, result);
		} else {
			System.out.printf("FALSE: expected:%2d result:%2d", expected, result);
		}
		System.out.println("");
	}

	public static void main(String[] args) throws Exception {
		MaxSliceSum nof = new MaxSliceSum();
		Method met = nof.getClass().getMethod("solution2", int[].class);
		printResult(1, (int) met.invoke(nof, new int[] { -2, 1 }));
		printResult(5, (int) met.invoke(nof, new int[] { 3, 2, -6, 4, 0 }));
		printResult(-2, (int) met.invoke(nof, new int[] { -2, -3, -100, -60, -40 }));
		printResult(3, (int) met.invoke(nof, new int[] { 3, -2, -40, -60, -100 }));
	}

	/**
	 * N is an integer within the range [1..1,000,000]; each element of array A
	 * is an integer within the range [−1,000,000..1,000,000]; the result will
	 * be an integer within the range [−2,147,483,648..2,147,483,647].
	 * 
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		int[] K = new int[A.length];
		K[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			int s = Math.max(K[i - 1], 0) + A[i];
			K[i] = s;
		}
		Arrays.sort(K);
		return K[K.length - 1];
	}

	public int solution2(int[] A) {
		int maxEndingHere = A[0];
		int maxSoFar = A[0];
		for (int i = 1; i < A.length; i++) {
			maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}

}
