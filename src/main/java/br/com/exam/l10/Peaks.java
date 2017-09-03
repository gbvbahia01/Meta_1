package br.com.exam.l10;

/**
 * A non-empty zero-indexed array A consisting of N integers is given.

A peak is an array element which is larger than its neighbors. More precisely, it is an index P such that 0 < P < N − 1,  A[P − 1] < A[P] and A[P] > A[P + 1].

For example, the following array A:

    A[0] = 1
    A[1] = 2
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2
has exactly three peaks: 3, 5, 10.

We want to divide this array into blocks containing the same number of elements. More precisely, we want to choose a number K that will yield the following blocks:

A[0], A[1], ..., A[K − 1],
A[K], A[K + 1], ..., A[2K − 1],
...
A[N − K], A[N − K + 1], ..., A[N − 1].
What's more, every block should contain at least one peak. Notice that extreme elements of the blocks (for example A[K − 1] or A[K]) can also be peaks, but only if they have both neighbors (including one in an adjacent blocks).

The goal is to find the maximum number of blocks into which the array A can be divided.

Array A can be divided into blocks as follows:

one block (1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2). This block contains three peaks.
two blocks (1, 2, 3, 4, 3, 4) and (1, 2, 3, 4, 6, 2). Every block has a peak.
three blocks (1, 2, 3, 4), (3, 4, 1, 2), (3, 4, 6, 2). Every block has a peak. Notice in particular that the first block (1, 2, 3, 4) has a peak at A[3], because A[2] < A[3] > A[4], even though A[4] is in the adjacent block.
However, array A cannot be divided into four blocks, (1, 2, 3), (4, 3, 4), (1, 2, 3) and (4, 6, 2), because the (1, 2, 3) blocks do not contain a peak. Notice in particular that the (4, 3, 4) block contains two peaks: A[3] and A[5].

The maximum number of blocks that array A can be divided into is three.

Write a function:

class Solution { public int solution(int[] A); }
that, given a non-empty zero-indexed array A consisting of N integers, returns the maximum number of blocks into which A can be divided.

If A cannot be divided into some number of blocks, the function should return 0.

For example, given:

    A[0] = 1
    A[1] = 2
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2
the function should return 3, as explained above.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [0..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N*log(log(N)));
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 */
import java.lang.reflect.Method;

public class Peaks {

	private static void printResult(int expected, int result) {
		if (expected == result) {
			System.out.printf("TRUE : expected:%2d result:%2d", expected, result);
		} else {
			System.out.printf("FALSE: expected:%2d result:%2d", expected, result);
		}
		System.out.println("");
	}

	public static void main(String[] args) throws Exception {
		Peaks nof = new Peaks();
		Method met = nof.getClass().getMethod("mySolution", int[].class);
		printResult(0, (int) met.invoke(nof, new int[] { 1, 2, 3, 4, 5, 6 }));
		printResult(3, (int) met.invoke(nof, new int[] { 1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 }));
		printResult(3, (int) met.invoke(nof, new int[] { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 }));
		printResult(3, (int) met.invoke(nof, new int[] { 6, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 }));
		printResult(0, (int) met.invoke(nof, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 }));
		printResult(0, (int) met.invoke(nof, new int[] { 91, 82, 73, 64, 55, 46, 37, 28, 19, 10, 5, 3 }));
		printResult(1, (int) met.invoke(nof, new int[] { 91, 82, 73, 64, 55, 46, 37, 28, 19, 100, 5, 3 }));
		printResult(3, (int) met.invoke(nof, new int[] { 7, 10, 4, 5, 7, 4, 6, 1, 4, 3, 3, 7 }));
		printResult(2, (int) met.invoke(nof, new int[] { 9, 9, 4, 3, 5, 4, 5, 2, 8, 9, 3, 1 }));
		printResult(1, (int) met.invoke(nof, new int[] { 9, 9, 4, 3, 2, 4, 5, 2, 8, 9, 3, 1 }));
		printResult(1, (int) met.invoke(nof, new int[] { 1, 3, 2, 1 }));
		printResult(1, (int) met.invoke(nof, new int[] { 0, 1, 0, 0, 0 }));
		printResult(1, (int) met.invoke(nof, new int[] { 0, 1, 0, 0, 1, 0, 1 }));
	}

	public int mySolution(int[] A) {
		int N = A.length;
		java.util.ArrayList<Integer> peaks = new java.util.ArrayList<Integer>();
		for (int i = 1; i < N - 1; i++) {
			if (A[i] > A[i - 1] && A[i] > A[i + 1])
				peaks.add(i);
		}
		if (peaks.size() <= 1) {
			return peaks.size();
		}
		int pIni = peaks.get(0);
		for (int size = pIni; size <= N; size++) {
			if (N % size != 0)
				continue;
			int find = 0;
			int blocks = N / size;
			boolean divided = true;
			for (int peakPos : peaks) {
				if (peakPos / size > find) {
					divided = false;
					break;
				} else if (peakPos / size == find) {
					find++;
				}
			}
			if(find != blocks)divided = false;
			if(divided) return blocks;
		}
		return 0;
	}

	// https://rafal.io/posts/codility-peaks.html
	public int solution2(int[] A) {
		int N = A.length;
		java.util.ArrayList<Integer> peaks = new java.util.ArrayList<Integer>();
		for (int i = 1; i < N - 1; i++) {
			if (A[i] > A[i - 1] && A[i] > A[i + 1])
				peaks.add(i);
		}
		if (peaks.size() <= 1) {
			return peaks.size();
		}
		for (int size = peaks.get(0); size <= N; size++) {
			if (N % size != 0)
				continue; // skip if non-divisible
			int find = 0;
			int groups = N / size;
			boolean ok = true;
			// Find whether every group has a peak
			for (int peakIdx : peaks) {
				if (peakIdx / size > find) {
					ok = false;
					break;
				}
				if (peakIdx / size == find)
					find++;
			}
			if (find != groups)
				ok = false;
			if (ok)
				return groups;
		}
		return 0;
	}

	/**
	 * N is an integer within the range [1..100,000]; each element of array A is
	 * an integer within the range [0..1,000,000,000].
	 * 
	 * @param A
	 * @return the maximum number of blocks into which A can be divided.
	 */
	public int solution(int[] A) {
		int length = A.length;
		if (A == null || length < 2) {
			return 0;
		}
		java.util.List<int[]> peaks = new java.util.ArrayList<>();
		for (int i = 1; i < A.length - 1; i++) {
			if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
				peaks.add(new int[] { A[i], i });
			}
		}
		int peaksSize = peaks.size();
		if (peaksSize <= 1) {
			return peaksSize;
		}
		if (length < 4) {
			return 1;
		}
		if (peaks.get(0)[1] + 1 > length / 2) {
			return 0;
		}
		int divided = peaksSize;
		while (!confirmPeaks(divided, peaks, length) && divided > 0) {
			divided--;
		}
		return divided;
	}

	private boolean confirmPeaks(int div, java.util.List<int[]> peaks, int length) {
		int part = 1;
		int jumpPart = length / div;
		int peakInx = 0;
		boolean peakPartFound = false;
		for (int i = 0; i < length; i++) {
			if (i == jumpPart * part) {
				part++;
				if (!peakPartFound)
					return false;
				peakPartFound = false;
			}
			if (!peakPartFound && peakInx < peaks.size() && peaks.get(peakInx)[1] < jumpPart * part) {
				peakPartFound = true;
				while (peakInx < peaks.size() && peaks.get(peakInx)[1] < jumpPart * part) {
					peakInx++;
				}
				i = jumpPart * part - 1;
			} else if (peakInx < peaks.size() && !peakPartFound && peaks.get(peakInx)[1] >= jumpPart * part) {
				return false;
			}
		}
		return peakPartFound;
	}
}
