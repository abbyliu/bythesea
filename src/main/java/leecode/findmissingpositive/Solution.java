package leecode.findmissingpositive;
/*
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
O(n), O(1)
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int firstMissingPositive2(int[] A) {
		if (A == null || A.length == 0) return 1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != i+1) {
				if (A[i] <= 0 || A[i] > A.length || A[i] == A[A[i]-1]) {
					continue;
				} else {
					int tmp = A[i];
					A[i] = A[A[i]-1];
					A[tmp-1] = tmp;
					i = i-1;
				}
			}
		}
		for (int i = 0 ;i < A.length; i++) {
			if (A[i] != i+1) {
				return i+1;
			}
		}
		return A.length+1;
	}
    public int firstMissingPositive(int[] A) {
    	if (A == null || A.length == 0) return 1;
    	int i = 0; 
    	while ( i <A.length) {
    		if (A[i] != i+1 && A[i] <= A.length && A[i] > 0
    				&& A[A[i]-1] != A[i]) {
    			int temp = A[A[i]-1];
    			A[A[i]-1] = A[i];
    			A[i] = temp;
    		} else {
    			i++;
    		}
    	}
    	for (i = 0;i < A.length;i++) {
    		if (A[i] != i+1) {
    			return i+1;
    		}
    	}
    	return A.length+1;
    }
}
