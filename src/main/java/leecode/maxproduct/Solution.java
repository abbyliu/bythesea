package leecode.maxproduct;

public class Solution {
	   public int maxProduct(int[] A) {
	       int product1 = 1;
	       int product2 = 1;
	       int max = A[0];
	       boolean newNegative = false;
	       for (int i = 0; i < A.length; i++) {
	           if ( A[i] == 0 ) {
	               product1 = 1;
	               newNegative = false;
	               max = Math.max(A[i], max);
	           } else {
	               product1 *= A[i];
	               max = Math.max(product1, max);
	               
	               if (newNegative) {
	                   product2 *= A[i];
	                   max = Math.max(product2, max);
	               }
	               
	               if (A[i] < 0 && !newNegative) {
	                   newNegative = true;
	                   product2 = 1;
	               }
	           }
	       }
	       return max;
	   }
	}