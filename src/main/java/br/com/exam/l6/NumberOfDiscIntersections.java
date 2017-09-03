package br.com.exam.l6;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

/**
 * We draw N discs on a plane. The discs are numbered from 0 to N − 1. A
 * zero-indexed array A of N non-negative integers, specifying the radiuses of
 * the discs, is given. The J-th disc is drawn with its center at (J, 0) and
 * radius A[J].
 * 
 * We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and
 * K-th discs have at least one common point (assuming that the discs contain
 * their borders).
 * 
 * The figure below shows discs drawn for N = 6 and A as follows:
 * 
 * A[0] = 1 A[1] = 5 A[2] = 2 A[3] = 1 A[4] = 4 A[5] = 0 >
 * 
 * There are eleven (unordered) pairs of discs that intersect, namely:
 * 
 * discs 1 and 4 intersect, and both intersect with all the other discs; disc 2
 * also intersects with discs 0 and 3. Write a function:
 * 
 * class Solution { public int solution(int[] A); } that, given an array A
 * describing N discs as explained above, returns the number of (unordered)
 * pairs of intersecting discs. The function should return −1 if the number of
 * intersecting pairs exceeds 10,000,000.
 * 
 * Given array A shown above, the function should return 11, as explained above.
 * 
 * Assume that:
 * 
 * N is an integer within the range [0..100,000]; each element of array A is an
 * integer within the range [0..2,147,483,647]. Complexity:
 * 
 * expected worst-case time complexity is O(N*log(N)); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 * 
 * @author A0061298
 *
 */
public class NumberOfDiscIntersections {

	private static void printResult(int expected, int result) {
		if (expected == result) {
			System.out.printf("TRUE : expected:%2d result:%2d", expected, result);
		} else {
			System.out.printf("FALSE: expected:%2d result:%2d", expected, result);
		}
		System.out.println("");
	}

	public static void main(String[] args) throws Exception {
		NumberOfDiscIntersections nof = new NumberOfDiscIntersections();
		Method met = nof.getClass().getMethod("solution5", int[].class);
		printResult(15, (int) met.invoke(nof, new int[] { 3, 3, 3, 5, 1, 2 }));// 15
		printResult(2, (int) met.invoke(nof, new int[] { 1, 2147483647, 0 }));// 2
		printResult(6, (int) met.invoke(nof, new int[] { 1, 0, 1, 0, 1 }));// 6
		printResult(11, (int) met.invoke(nof, new int[] { 1, 5, 2, 1, 4, 0 }));// 11
		printResult(9, (int) met.invoke(nof, new int[] { 1, 1, 1, 1, 1, 1 }));// 9
		printResult(3, (int) met.invoke(nof, new int[] { 1, 1, 1 }));// 3
		printResult(0, (int) met.invoke(nof, new int[] { 0, 0, 0, 0, 0, 0 }));// 0
		printResult(10, (int) met.invoke(nof, new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
				Integer.MAX_VALUE, Integer.MAX_VALUE }));// 10
	}

	public int solution5(int[] A) {
		if (A.length == 0 || A.length == 1) {
			return 0;
		}
		int length = A.length;
		XiXe[] ies = new XiXe[length];
		for (int i = 0; i < length; i++) {
			ies[i] = new XiXe(i - (long) A[i], i + (long) A[i], i);
		}
		Arrays.sort(ies, ies[0]);
		int macth = 0;
		for (int i = 0; i < length - 1; i++) {
			boolean stop = false;
			int next = i + 1;
			while (!stop && next < length) {
				if (ies[i].e >= ies[next++].i) {
					macth++;
					if (macth > 10000000)
						return -1;
				} else {
					stop = true;
				}
			}
		}
		return macth;
	}

	class XiXe implements Comparator<XiXe> {
		long i, e;
		int p;

		public XiXe(long i, long e, int p) {
			super();
			this.i = i;
			this.e = e;
			this.p = p;
		}

		@Override
		public int compare(XiXe o1, XiXe o2) {
			if (o1.i < o2.i) {
				return -1;
			}
			if (o1.i > o2.i) {
				return 1;
			} // both 'i' are the same (==)
			if (o1.e < o2.e) {
				return -1;
			}
			if (o1.e > o2.e) {
				return 1;
			}
			return o1.p > o2.p ? -1 : 1;
		}

		@Override
		public String toString() {
			return "[i=" + i + " p=" + p + " e=" + e + "]";
		}

	}

	public int solution4(int[] A) {
		int macth = 0;
		int length = A.length;
		for (int i = 0; i < length - 1; i++) {
			long r = A[i];
			long ii = i;
			macth += (ii + r < length - 1) ? A[i] : length - 1 - i;
			if (ii + r + 1 < length) {// Max int protection
				for (int j = i + A[i] + 1; j < length; j++) {
					if (i + r >= j - A[j]) {
						macth++;
					}
					if (macth > 10000000)
						return -1;
				}
			}
		}
		return macth;
	}

	// Works but not faster
	public int solution3(int[] A) {
		java.util.HashSet<ArraysIndex> index = new java.util.HashSet<>();
		for (int i = 0; i < A.length - 1; i++) {
			long r = A[i];

			for (int j = i + 1; j < A.length; j++) {
				if (i + r >= j - A[j]) {
					index.add(new ArraysIndex(i, j));
					if (index.size() > 10000000) {
						return -1;
					}
				}
			}
		}
		return index.size();
	}

	public int solution(int[] A) {
		if (A.length == 0 || A.length == 1) {
			return 0;
		}
		java.util.HashSet<ArraysIndex> index = new java.util.HashSet<>();
		for (int i = 0; i < A.length; i++) {
			int forward = A[i];
			if (forward + i >= A.length) {
				forward = A.length - 1 - i;
			}
			int backward = A[i];
			if (backward > i) {
				backward = i;
			}
			while (forward > 0) {
				index.add(new ArraysIndex(i, (i + forward--)));
			}
			while (backward > 0) {
				index.add(new ArraysIndex(i, (i - backward--)));
			}
		}
		System.out.println(index);
		return index.size();
	}

	class ArraysIndex {
		int i1, i2;

		public ArraysIndex(int i1, int i2) {
			super();
			this.i1 = i1;
			this.i2 = i2;
		}

		@Override
		public String toString() {
			return "[i1=" + i1 + ", i2=" + i2 + "]";
		}

		@Override
		public int hashCode() {
			return i1 + i2;
		}

		@Override
		public boolean equals(Object obj) {
			ArraysIndex other = (ArraysIndex) obj;
			if (i1 == other.i1 || i2 == other.i2) {
				return true;
			}
			if (i1 == other.i2 || i2 == other.i1) {
				return true;
			}
			return false;
		}
	}

	public int solution2(int[] A) {
		int[][] disc = new int[A.length][2];
		for (int i = 0; i < A.length; i++) {
			int downBound = i - A[i];
			int upBound = i + A[i];
			disc[i][0] = downBound;
			disc[i][1] = upBound;
		}
		int pairCounter = 0;
		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (disc[i][1] >= disc[j][0]) {
					pairCounter++;
				} else {
					// break;
				}
			}
		}
		return pairCounter;
	}
}
