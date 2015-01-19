package leecode.trappingrainwater;


/*  Trapping Rain Water
 *  Given n non-negative integers representing an elevation map
 *   where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 

O(N)
 */
public class Solution {

    public int trap(int[] A) {
    	if (A == null || A.length <=1) return 0;
    	int[] maxLeft = new int[A.length];
    	int maxH = A[0];
    	for (int i = 1; i < A.length; i++) {
    		maxLeft[i] = maxH;
    		if (maxH < A[i]) {
    			maxH = A[i];
    		}
    	}
    	int trapped = 0;
    	maxH = A[A.length-1];
    	for (int i = A.length-2; i > 0; i--) {
    		int left = maxLeft[i];
    		int right = maxH;
    		int container = Math.min(left, right);
    		if (container > A[i]) {
    			trapped = trapped + (container - A[i]);
    		}
    		if (maxH < A[i]) {
    			maxH = A[i];
    		}
    	}
    	return trapped;
    }
    
    public int trap2(int[] A) {
        if (A == null || A.length == 0) return 0;
        int[] maxHeightL = new int[A.length];
        int max = 0;
        for (int i = 0; i < A.length;i++ ) {
            maxHeightL[i] = max;
            if (A[i] > max) {
                max = A[i];
            }
        }
        int total = 0;
        max = 0;
        for (int i = A.length-1 ; i>=0;i--) {
            int v = Math.min(maxHeightL[i], max);
            if (v > A[i]) {
                total += (v - A[i]);
            }
            if (A[i] > max) {
                max = A[i];
            }
        }
        return total;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
