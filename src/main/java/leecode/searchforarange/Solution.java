package leecode.searchforarange;
/*
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]. 
O(lgn) worse case O(n)
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] searchRange(int[] A, int target) {
		int[] returns = new int[2];
		returns[0] = -1; returns[1] = -1;
    	if (A == null || A.length ==0) return returns;
    	double small8 = target - 0.1;
    	double bigger8 = target + 0.1;
    	int first = binarySearch(A, small8);
    	int second = binarySearch(A, bigger8);
    	
    	if (first == second) {
    		if (A[first] == target) {
    			returns[0] = first;
    			returns[1] = second;
    		}
    	} else {
    		if (A[first] != target) {
    			first++;
    		}
    		if (A[second]  != target) {
    			second --;
    		}
    		returns[0] = first;
    		returns[1] = second;
    	}
    	return returns;
    	
    }
	private int binarySearch(int[] a, double v) {
		int start = 0;
		int end = a.length -1;
		while (start < end) {
			int mid = start + (end-start)/2;
			int va = a[mid];
			if (va < v) {
				start = mid+1;
			} else {
				end = mid -1;
			}
		}
		return start;
	}
}
