package leecode.removreduplicatesfromarray;
/*
 *  Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2]. 
O(N)
 */
public class Solution {
    public int removeDuplicates(int[] A) {
    	if (A == null || A.length == 0 ) return 0;
    	int idx = 1;
    	int start = 1;
    	int previous = A[0]; 
    	while (start < A.length) {
    		if (A[start] != previous) {
    			A[idx] = A[start];
    			previous = A[idx];
    			idx++;
    		}
			start++;
    	}
    	int num = idx;
    	while (idx < A.length) {
    		A[idx] = 0;
    		idx++;
    	}
    	return num;
    }
}