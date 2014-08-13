package leecode.searchrotatedarray2;
/*
 * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
O(logN) worst O(N)
 */
public class Solution {
    public boolean search(int[] A, int target) {
    	if (A == null || A.length == 0) return false;
    	
    	int start = 0;
    	int end = A.length -1;
    	
    	while (start <= end) {
        	int mid = start + (end-start)/2;
    		if (A[mid] == target) return true;
    		if (A[start] > A[mid]) {
    			if (target < A[mid]) {
    				end = mid -1;
    			} else if (target < A[start]) {
    				start = mid + 1;
    			} else {
    				end = mid -1;
    			}
    		} else if (A[start] < A[mid]) {
    			if (target > A[mid]) {
    				start = mid+1;
    			} else if (target < A[start]) {
    				start = mid + 1;
    			} else {
    				end = mid - 1;
    			}
    		} else {
    			do {
    				start = start + 1;
    			} while (start <= end && A[start] == A[mid]);
    		}
    	}
    	return false;
    }
}