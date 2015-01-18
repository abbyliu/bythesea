package leecode.maxproduct;

/* Maximum Product Subarray */
public class Solution {
	   public int maxProduct(int[] A) {
		   if ( A == null || A.length == 0) {
			   return 0;
		   }
		   
	       int product1 = 1;
	       int product2 = 1;
	       int max = A[0];
	       boolean newNegative = false;
	       
	       for (int i = 0; i < A.length; i++) {
	    	   product1 *= A[i];
	    	   if (product1 > max) {
	    		   max = product1;
	    	   }
	    	   
	           if ( A[i] == 0 ) {
	               product1 = 1;
	               newNegative = false;
	           } else {
	               if (newNegative) {
	                   product2 *= A[i];
	                   if (product2 > max) {
	                	   max = product2;
	                   }
	               } else if (A[i] < 0) {
	                   newNegative = true;
	                   product2 = 1;
	               }
	           }
	       }
	       
	       return max;
	   }
	}