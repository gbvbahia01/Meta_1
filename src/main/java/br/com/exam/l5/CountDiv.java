package br.com.exam.l5;

/**
 * Write a function:
 * 
 * class Solution { public int solution(int A, int B, int K); } that, given
 * three integers A, B and K, returns the number of integers within the range
 * [A..B] that are divisible by K, i.e.:
 * 
 * { i : A ≤ i ≤ B, i mod K = 0 } For example, for A = 6, B = 11 and K = 2, your
 * function should return 3, because there are three numbers divisible by 2
 * within the range [6..11], namely 6, 8 and 10.
 * 
 * Assume that:
 * 
 * A and B are integers within the range [0..2,000,000,000]; K is an integer
 * within the range [1..2,000,000,000]; A ≤ B. Complexity:
 * 
 * expected worst-case time complexity is O(1); expected worst-case space
 * complexity is O(1).
 * 
 * @author A0061298
 *
 */
public class CountDiv {
	public static void main(String[] args) {
		System.out.println(solution(6,11,2));
		System.out.println(solution(5,11,2));
		System.out.println(solution(0,0,1));
		System.out.println(solution(2000000000,0,2000000000));
		System.out.println(solution(0,2000000000,2000000000));
		System.out.println(solution(0,2000000000,5));
	}

	public static int solution(int A, int B, int K) {
		int num = B/K - A/K;
		if(A % K == 0)num++;
		return num;
	}
}
