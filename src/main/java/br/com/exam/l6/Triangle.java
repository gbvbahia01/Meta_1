package br.com.exam.l6;

/**
 * A zero-indexed array A consisting of N integers is given. A triplet (P, Q, R)
 * is triangular if 0 ≤ P < Q < R < N and:
 * 
 * A[P] + A[Q] > A[R], A[Q] + A[R] > A[P], A[R] + A[P] > A[Q]. For example,
 * consider array A such that:
 * 
 * A[0] = 10 A[1] = 2 A[2] = 5 A[3] = 1 A[4] = 8 A[5] = 20 Triplet (0, 2, 4) is
 * triangular.
 * 
 * Write a function:
 * 
 * int solution(int A[], int N); that, given a zero-indexed array A consisting
 * of N integers, returns 1 if there exists a triangular triplet for this array
 * and returns 0 otherwise.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 10 A[1] = 2 A[2] = 5 A[3] = 1 A[4] = 8 A[5] = 20 the function should
 * return 1, as explained above. Given array A such that:
 * 
 * A[0] = 10 A[1] = 50 A[2] = 5 A[3] = 1 the function should return 0.
 * 
 * Assume that:
 * 
 * N is an integer within the range [0..100,000]; each element of array A is an
 * integer within the range [−2,147,483,648..2,147,483,647]. Complexity:
 * 
 * expected worst-case time complexity is O(N*log(N)); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified
 * 
 * @author A0061298
 *
 */
public class Triangle {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}));//1
		//System.out.println(solution(new int[]{10,2,5,1,8,20}));//1
		//System.out.println(solution(new int[]{10,50,5,1}));//0
		//System.out.println(solution(new int[]{-10,-50,-5,-1}));//0
		//System.out.println(solution(new int[]{-10,-50,5,-1}));
	}
	
	public static int solution(int[] A){
		if(A.length < 3){
			return 0;
		}
		java.util.Arrays.sort(A);
		for(int i = 0; i < A.length - 2; i++){
			long i1 = A[i];
			long i2 = A[i + 1];
			long i3 = A[i + 2];
			if(i1 + i2 > i3){
				//System.out.println("A[i]:" + A[i] + " A[i + 1]:" + A[i + 1] + " > A[i + 2]:" + A[i + 2]);
				return 1;
			}
		}
		return 0;
	}
}
