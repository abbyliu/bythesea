package leecode.removeduplicatedarray2;

/*
 Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3]. 
 */
public class Solution {
    public int removeDuplicates(int[] A) {
    	if (A == null || A.length == 0 ) return 0;
    	if (A.length == 1) return 1;
    	int idx = 1;
    	int start = 1;
    	int previous = A[0];
    	int sameCount = 1;
    	while (start < A.length) {
    		if (A[start] != previous) {
    			A[idx] = A[start];
    			previous = A[idx];
    			idx++;
    			sameCount = 1;
    		} else {
    			if (sameCount == 1) {
	    			sameCount = 2;
	    			A[idx] = A[start];
	    			idx++;
    			} 
    		} 
    		start = start+1;
    	}
    	int num = idx;
    	while (idx < A.length) {
    		A[idx] = 0;
    		idx++;
    	}
    	return num;
    }
}