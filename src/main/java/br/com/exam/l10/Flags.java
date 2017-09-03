package br.com.exam.l10;

import java.lang.reflect.Method;

/**
 * A non-empty zero-indexed array A consisting of N integers is given.
 * 
 * A peak is an array element which is larger than its neighbours. More
 * precisely, it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P] > A[P
 * + 1].
 * 
 * For example, the following array A:
 * 
 * A[0] = 1 A[1] = 5 A[2] = 3 A[3] = 4 A[4] = 3 A[5] = 4 A[6] = 1 A[7] = 2 A[8]
 * = 3 A[9] = 4 A[10] = 6 A[11] = 2 has exactly four peaks: elements 1, 3, 5 and
 * 10.
 * 
 * You are going on a trip to a range of mountains whose relative heights are
 * represented by array A, as shown in a figure below. You have to choose how
 * many flags you should take with you. The goal is to set the maximum number of
 * flags on the peaks, according to certain rules.
 * 
 * >
 * 
 * Flags can only be set on peaks. What's more, if you take K flags, then the
 * distance between any two flags should be greater than or equal to K. The
 * distance between indices P and Q is the absolute value |P − Q|.
 * 
 * For example, given the mountain range represented by array A, above, with N =
 * 12, if you take:
 * 
 * two flags, you can set them on peaks 1 and 5; three flags, you can set them
 * on peaks 1, 5 and 10; four flags, you can set only three flags, on peaks 1, 5
 * and 10. You can therefore set a maximum of three flags in this case.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty zero-indexed array A of N integers, returns the
 * maximum number of flags that can be set on the peaks of the array.
 * 
 * For example, the following array A:
 * 
 * A[0] = 1 A[1] = 5 A[2] = 3 A[3] = 4 A[4] = 3 A[5] = 4 A[6] = 1 A[7] = 2 A[8]
 * = 3 A[9] = 4 A[10] = 6 A[11] = 2 the function should return 3, as explained
 * above.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..400,000]; each element of array A is an
 * integer within the range [0..1,000,000,000]. Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 * 
 * @author A0061298
 *
 */
public class Flags {

	private static void printResult(int expected, int result) {
		if (expected == result) {
			System.out.printf("TRUE : expected:%2d result:%2d", expected, result);
		} else {
			System.out.printf("FALSE: expected:%2d result:%2d", expected, result);
		}
		System.out.println("");
	}

	public static void main(String[] args) throws Exception {
		Flags nof = new Flags();
		Method met = nof.getClass().getMethod("solution", int[].class);
		printResult(3, (int) met.invoke(nof, new int[]{1,5,3,4,3,4,1,2,3,4,6,2}));
		printResult(2, (int) met.invoke(nof, new int[]{6,5,3,4,3,4,1,2,3,4,6,2}));
		printResult(0, (int) met.invoke(nof, new int[]{1,2,3,4,5,6,7,8,9,10,11,12}));
		printResult(0, (int) met.invoke(nof, new int[]{91,82,73,64,55,46,37,28,19,10,5,3}));
		printResult(1, (int) met.invoke(nof, new int[]{91,82,73,64,55,46,37,28,19,100,5,3}));
		printResult(3, (int) met.invoke(nof, new int[]{7, 10, 4, 5, 7, 4, 6, 1, 4, 3, 3, 7}));
		printResult(2, (int) met.invoke(nof, new int[]{9, 9, 4, 3, 5, 4, 5, 2, 8, 9, 3, 1}));
	}

	/**
	 * N is an integer within the range [1..400,000];
	 * each element of array A is an integer within the range [0..1,000,000,000].
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		if(A.length <= 2){
			return 0;
		}//1,5,3,4,3,4,1,2,3,4,6,2
		java.util.List<int[]> peaks = new java.util.ArrayList<>();
		for (int i = 1; i < A.length - 1; i++) {
			if(A[i - 1] < A[i] && A[i] > A[i + 1]){
				peaks.add(new int[]{A[i], i});
			}
		}
		int peaksSize = peaks.size();
		if(peaksSize <= 1){
			return peaks.size();
		}
	    int maxDistance = peaks.get(peaksSize - 1)[1] - peaks.get(0)[1];
	    int maxFlags = ((int)Math.sqrt((maxDistance))) + 1;
		while (!confirmFlags(maxFlags, peaks) && maxFlags > 0) {
			maxFlags--;
		}
		return maxFlags;
	}
	
	private boolean confirmFlags(int flags, java.util.List<int[]> peaks){
		int countFlags = 1;
		int[] lastFlag = peaks.get(0);
		for(int i = 1; i < peaks.size(); i++){
			if(peaks.get(i)[1] - lastFlag[1] >= flags){
				countFlags++;
				if(countFlags >= flags)break;
				lastFlag =peaks.get(i); 
			}
		}
		return countFlags >= flags;
	}
}
