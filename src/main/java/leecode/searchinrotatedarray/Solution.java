package leecode.searchinrotatedarray;
/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
O(logN)
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[] {4,5,6,7,0,1,2};
		Solution s = new Solution ();
		s.search(A, 1);
	}

    public int search(int[] A, int target) {
    	if (A == null ||A.length == 0) return -1;
    	
    	int start = 0;
    	int end = A.length-1;
    	while (start < end) {
    		int mid = start + (end-start)/2;
    		if (A[mid] == target) {
    			return mid;
    		} else if (A[start] > A[mid]) {
    			if (target < A[mid]) {
    				end = mid -1;
    			} else if (target < A[start]) {
    				start = mid + 1;
    			} else {
    				end = mid -1;
    			}
    		} else {
    			if (target > A[mid]) {
    				start = mid + 1;
    			} else if (target >= A[start]) {
    				end = mid -1;
    			} else {
    				start = mid +1;
    			}
    		}
    	}
    	if (A[start] == target) return start;
    	else return -1;
    }
    
    
}
