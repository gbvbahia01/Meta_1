package br.com.exam.l5;

import java.util.Arrays;

/**
 * A DNA sequence can be represented as a string consisting of the letters A, C,
 * G and T, which correspond to the types of successive nucleotides in the
 * sequence. Each nucleotide has an impact factor, which is an integer.
 * Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4,
 * respectively. You are going to answer several queries of the form: What is
 * the minimal impact factor of nucleotides contained in a particular part of
 * the given DNA sequence?
 * 
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1]
 * consisting of N characters. There are M queries, which are given in non-empty
 * arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M)
 * requires you to find the minimal impact factor of nucleotides contained in
 * the DNA sequence between positions P[K] and Q[K] (inclusive).
 * 
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 * 
 * P[0] = 2 Q[0] = 4 P[1] = 5 Q[1] = 5 P[2] = 0 Q[2] = 6 The answers to these M
 * = 3 queries are as follows:
 * 
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C
 * (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
 * The part between positions 5 and 5 contains a single nucleotide T, whose
 * impact factor is 4, so the answer is 4. The part between positions 0 and 6
 * (the whole string) contains all nucleotides, in particular nucleotide A whose
 * impact factor is 1, so the answer is 1. Write a function:
 * 
 * class Solution { public int[] solution(String S, int[] P, int[] Q); } that,
 * given a non-empty zero-indexed string S consisting of N characters and two
 * non-empty zero-indexed arrays P and Q consisting of M integers, returns an
 * array consisting of M integers specifying the consecutive answers to all
 * queries.
 * 
 * The sequence should be returned as:
 * 
 * a Results structure (in C), or a vector of integers (in C++), or a Results
 * record (in Pascal), or an array of integers (in any other programming
 * language). For example, given the string S = CAGCCTA and arrays P, Q such
 * that:
 * 
 * P[0] = 2 Q[0] = 4 P[1] = 5 Q[1] = 5 P[2] = 0 Q[2] = 6 the function should
 * return the values [2, 4, 1], as explained above.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..100,000]; M is an integer within the
 * range [1..50,000]; each element of arrays P, Q is an integer within the range
 * [0..N − 1]; P[K] ≤ Q[K], where 0 ≤ K < M; string S consists only of
 * upper-case English letters A, C, G, T. Complexity:
 * 
 * expected worst-case time complexity is O(N+M); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 * 
 * @author A0061298
 *
 */
public class GenomicRangeQuery {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("CAGCCTA", new int[] { 2 }, new int[] { 4 })));
		System.out.println(Arrays.toString(solution("CAGCCTA", new int[] { 2, 5, 0 }, new int[] { 4, 5, 6 })));
		System.out.println(Arrays.toString(solution("C", new int[] { 0, 0, 0 }, new int[] { 0, 0, 0 })));
		System.out.println(Arrays.toString(solution("CGACCTT", new int[] { 1, 2, 3 }, new int[] { 2, 4, 6 })));
		//System.out.println(Arrays.toString(solution("CGACCTTCGACCTTCGACCTTCGACCTTCGACCTTCGACCTTCGACCTT",
		//		new int[] { 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 2 },
		//		new int[] { 2, 4, 6, 3, 4, 5, 6, 2, 4, 6, 3, 4, 5, 6, 3 })));
	}

	public static int[] solution(String S, int[] P, int[] Q) {
		int[] A = new int[S.length()];
		int[] C = new int[S.length()];
		int[] G = new int[S.length()];
		char[] CC = S.toCharArray();
		for (int c = 0; c < CC.length; c++) {
			if (CC[c] == ('A')) {
				fillPosition(A, C, G, c);
			} else if (CC[c] == ('C')) {
				fillPosition(C, A, G, c);
			} else if (CC[c] == ('G')) {
				fillPosition(G, C, A, c);
			} else {
				if (c > 0) {
					C[c] = C[c - 1];
					G[c] = G[c - 1];
					A[c] = A[c - 1];
				}
			}
		}
		int sz = P.length > Q.length ? Q.length : P.length;
		int[] sol = new int[sz];
		for (int i = 0; i < sz; i++) {
			int start = P[i];
			int end = Q[i];
			if (isRange(A, start, end)) {
				sol[i] = 1;
			}else if(isRange(C, start, end)) {
				sol[i] = 2;
			}else if (isRange(G, start, end)) {
				sol[i] = 3;
			}else{
				sol[i] = 4;
			}
		}
		return sol;
	}

	private static boolean isRange(int[] array, int start, int end) {
		return (start == 0 && (array[start] == 1 || array[end] > 0)) || (start > 0 && array[end] > array[start -1]);
	}

	private static void fillPosition(int[] ToFill, int[] toRepeat1, int[] toReapeat2, int position) {
		ToFill[position] = position == 0 ? ToFill[position] + 1 : ToFill[position - 1] + 1;
		if (position > 0) {
			toRepeat1[position] = toRepeat1[position - 1];
			toReapeat2[position] = toReapeat2[position - 1];
		}
	}

}
