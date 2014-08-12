package leecode.removeelement;
/*
 * Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
O(n) 
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int removeElement(int[] A, int elem) {
    	if (A == null || A.length == 0) return 0;
    	int idx = 0;
    	for (int i = 0; i < A.length; i++) {
    		if (A[i] != elem) {
    			A[idx] = A[i];
    			idx++;
    		}
    	}
    	return idx;
    }

}
