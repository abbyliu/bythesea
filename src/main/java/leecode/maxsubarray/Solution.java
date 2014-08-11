package leecode.maxsubarray;

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum. 
 */
public class Solution {
	public int maxSubArray4(int A[]) {
		if (A == null || A.length == 0) return 0;
		
		int max = A[0];
		int sum = A[0] < 0? 0: A[0];
		for (int i = 1; i < A.length; i++) {
			int v = sum + A[i];
			if (v <0) {
				sum = 0;
			} else {
				sum = v;
			}
			if (v > max) {
				max = v;
			}
		}
		return max;
		
	}
	
    int maxSubArray3(int A[], int n) {
        if(n==0) return 0;
        return maxSubArrayHelperFunction(A,0,n-1);
    }

    int maxSubArrayHelperFunction(int A[], int left, int right) {
        if(right == left) return A[left];
        int middle = (left+right)/2;
        int leftans = maxSubArrayHelperFunction(A, left, middle);
        int rightans = maxSubArrayHelperFunction(A, middle+1, right);
        int leftmax = A[middle];
        int rightmax = A[middle+1];
        int temp = 0;
        for(int i=middle;i>=left;i--) {
            temp += A[i];
            if(temp > leftmax) leftmax = temp;
        }
        temp = 0;
        for(int i=middle+1;i<=right;i++) {
            temp += A[i];
            if(temp > rightmax) rightmax = temp;
        }
        return Math.max(Math.max(leftans, rightans),leftmax+rightmax);
    }
	public int maxSubArray2(int[] A) {
	   	if (A == null || A.length == 0) return 0;
    	if (A.length == 1) return A[0];
    	int max = Integer.MIN_VALUE;
    	int curMax = 0;
    	for (int i = 0; i < A.length; i++) {
    		curMax = curMax + A[i];
    		max = Math.max(max, curMax);
    		if (curMax < 0) {
    			curMax = 0;
    		}
    	}
    	return max;
	}
    public int maxSubArray(int[] A) {
    	if (A == null || A.length == 0) return 0;
    	if (A.length == 1) return A[0];
    	int max = A[0];
    	int v = max;
    	for (int i = 1; i < A.length; i++) {
    		if (v <= 0) {
    			if (A[i] > v) {
    				if (A[i]> max) {
    					max = A[i];
    				}
    				v = A[i];
    			}
    		} else {
	    		int value = v + A[i];
	    		if (value > 0) {
	    			v = value;
		    		if (v > max) {
		    			max = v;
		    		}
	    		} else  {
	    			v = 0;
	    		}
    		}
    	}
    	return max;
    	
    }
}