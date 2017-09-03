package br.com.exam.l8;

/**
 * A non-empty zero-indexed array A consisting of N integers is given.

The leader of this array is the value that occurs in more than half of the elements of A.

An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

For example, given array A such that:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
we can find two equi leaders:

0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
The goal is to count the number of equi leaders.

Write a function:

class Solution { public int solution(int[] A); }
that, given a non-empty zero-indexed array A consisting of N integers, returns the number of equi leaders.

For example, given:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
the function should return 2, as explained above.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 */
import java.lang.reflect.Method;
import java.util.Stack;

public class EquiLeader {

	private static void printResult(int expected, int result) {
		if (expected == result) {
			System.out.printf("TRUE : expected:%2d result:%2d", expected, result);
		} else {
			System.out.printf("FALSE: expected:%2d result:%2d", expected, result);
		}
		System.out.println("");
	}

	public static void main(String[] args) throws Exception {
		EquiLeader nof = new EquiLeader();
		Method met = nof.getClass().getMethod("solution", int[].class);
		printResult(2, (int) met.invoke(nof, new int[] { 4, 3, 4, 4, 4, 2 }));
		printResult(4, (int) met.invoke(nof, new int[] { 3, 4, 3, 2, 3, -1, 3, 3 }));
		printResult(0, (int) met.invoke(nof, new int[] { 3, 4, 5, 2, 6, -1, 7, 3 }));
	}

	public int solution(int[] A) {
		int candidate = -1;
		int size = 0;
		int value = 0;
		for (int i = 0; i < A.length; i++) {
			if 		(size == 0)		{ value = A[i]; size++; }
			else if (value != A[i]) { size--; }
			else 					{ size++; }
		}
		if (size != 0){candidate = value;}
		int count = 0;
		int leader = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == candidate)
				count++;
			if (count > A.length / 2)
				leader = candidate;
		}
		int lcount = 0;
		int equiLeadersCount = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == leader)
				lcount++;
			int rcount = count - lcount;
			if (lcount > (int) (i + 1) / 2 && rcount > (int) (A.length - i - 1) / 2)
				equiLeadersCount++;

		}
		return equiLeadersCount;
	}

	// Slow
	public int solutionSlow(int[] A) {
		int[] leader = getLeader(A);
		if(leader[0] == Integer.MIN_VALUE){
			return 0;
		}
		int count = 0;
		int lCount = 0;
		for (int i = 0; i < A.length; i++) {
			if(A[i] == leader[0]){	lCount++;}
			int rCount = leader[1] - lCount;
			if(lCount > (i + 1) / 2 && rCount > (A.length - i - 1) / 2)	count++;
		}
		return count;
	}

	int[] getLeader(int[] B) {
		int length = B == null ? -1 : B.length;
		if (length == -1 || length == 0) {
			return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
		}
		if (length == 1) {
			return new int[]{B[0], 1};
		}
		Stack<Integer> leader = new Stack<>();
		for (int i = 0; i < length; i++) {
			if (leader.isEmpty()) {
				leader.push(B[i]);
			} else {
				if (leader.peek() == B[i]) {
					leader.push(B[i]);
				} else {
					leader.pop();
				}
			}
		}
		if (leader.isEmpty()) {
			return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
		}
		int candidate = leader.peek();
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (B[i] == candidate) {
				count++;
			}
		}
		if (count > length / 2)
			return new int[]{leader.peek(), count};
		else
			return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
	}
}
