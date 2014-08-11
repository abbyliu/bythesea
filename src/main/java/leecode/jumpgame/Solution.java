package leecode.jumpgame;
/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
O(n)
O(1)
 */

public class Solution {
	
	public boolean canJump2(int[] A) {
		if (A== null || A.length == 0) return false;
		if (A.length == 1) return true;
		int maxIdx = 0;
		for (int i = 0; i < A.length; i++) {
		    if (maxIdx >= A.length-1) return true;
			if (i <= maxIdx) {
				maxIdx = Math.max(maxIdx, i + A[i]);
			} else {
				return false;
			}
		}
		return true;
	}
	
    public boolean canJump(int[] A) {
    	if (A == null || A.length == 0) return false;
    	boolean[] can = new boolean[A.length];
    	can[0] = true;
    	
    	int current = 0;
    	int maxIdx = 0;
    	while (current < A.length && can[current]) {
	    	for (int i = maxIdx+1-current; i <= A[current]; i++) {
	    		int idx = current + i;
	    		if (idx < A.length) {
    	    		can[idx] = true;
    	    		if (idx > maxIdx) {
    	    			maxIdx = idx;
    	    		}
    	    		if (idx == A.length-1) return true;
	    		}
	    	} 
	    	current++;
    	}
    	return can[A.length-1];
    	
    }
}