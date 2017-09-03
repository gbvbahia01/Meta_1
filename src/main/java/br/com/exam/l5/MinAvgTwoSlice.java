package br.com.exam.l5;

/**
 * A non-empty zero-indexed array A consisting of N integers is given. A pair of
 * integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A
 * (notice that the slice contains at least two elements). The average of a
 * slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length
 * of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... +
 * A[Q]) / (Q − P + 1).
 * 
 * For example, array A such that:
 * 
 * A[0] = 4 A[1] = 2 A[2] = 2 A[3] = 5 A[4] = 1 A[5] = 5 A[6] = 8 contains the
 * following example slices:
 * 
 * slice (1, 2), whose average is (2 + 2) / 2 = 2; slice (3, 4), whose average
 * is (5 + 1) / 2 = 3; slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is
 * minimal.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty zero-indexed array A consisting of N integers,
 * returns the starting position of the slice with the minimal average. If there
 * is more than one slice with a minimal average, you should return the smallest
 * starting position of such a slice.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 4 A[1] = 2 A[2] = 2 A[3] = 5 A[4] = 1 A[5] = 5 A[6] = 8 the function
 * should return 1, as explained above.
 * 
 * Assume that:
 * 
 * N is an integer within the range [2..100,000]; each element of array A is an
 * integer within the range [−10,000..10,000]. Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 * 
 * @author A0061298
 *
 */
public class MinAvgTwoSlice {

	public static void main(String[] args) {
		System.out.println(new MinAvgTwoSlice().solution(new int[] { 4, 2, 2, 5, 1, 5, 8 }));
		System.out.println(new MinAvgTwoSlice().solution(new int[] { -3, -5, -8, -4, -10 }));// 2
	}

	public int solution(int[] A) {
		double minav = Double.MAX_VALUE;
		int minind = Integer.MAX_VALUE;
		int[] sum = new int[A.length + 1];
		sumArray(A, sum);
		int startpos = 0;
		for (int i = 1; i <= 2; i++) {
			startpos = 0;
			while (startpos + i < A.length) {
				double suma = getTotalSum(sum, startpos, startpos + i);
				double size = (startpos + i) - startpos + 1;
				double av = suma / size;
				if (av <= minav) {
					if (av < minav || startpos < minind) {
						minind = startpos;
					}
					minav = av;
				}
				startpos += 1;
			}
		}
		return minind;
	}

	void sumArray(int[] A, int[] sum) {
		for (int i = 1; i < sum.length; i++) {
			sum[i] = sum[i - 1] + A[i - 1];
		}
	}

	int getTotalSum(int[] sum, int start, int last) {
		return sum[last + 1] - sum[start];
	}
}
