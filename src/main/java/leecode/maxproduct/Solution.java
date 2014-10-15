package leecode.maxproduct;

public class Solution {
    public int maxProduct(int[] A) {
    	int prd1 = 1;
    	int prd2 = 1;
    	boolean newNeg = false;
    	int max = A[0];
    	for (int i = 0; i<A.length;i++) {
    		if (A[i] == 0) {
    			prd1 = 1;
    			newNeg = false;
    			if (max < 0) {
    				max = 0;
    			}
    		} else {
    			prd1 = prd1 * A[i];
    			if (prd1 > max) {
    				max = prd1;
    			}
    			if (newNeg) {
    				prd2 = prd2* A[i];
    				if (prd2 > max) {
    					max = prd2;
    				}
    			}
    			if (A[i] < 0 && !newNeg) {
    				newNeg = true;
    				prd2=1;
    			}
    		}
    	}
    	return max;
    }
}