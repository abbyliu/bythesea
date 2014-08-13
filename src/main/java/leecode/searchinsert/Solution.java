package leecode.searchinsert;

/*
 * O(lgn)
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int searchInsert(int[] A, int target) {
    	if (A == null || A.length == 0) return 0;
    	int start = 0;
    	int end = A.length-1;
    	while (start < end) {
    		int mid = start + (end -start)/2;
    		int v = A[mid];
    		if (v == target) {
    			return mid;
    		} else if (target > v) {
    			start = mid + 1;
    		} else {
    			end = mid -1;
    		}
    	}
    	if (target > A[start]) {
    		return start+1;
    	} else if (start > 0) {
    		return start--;
    	} else {
    		return start;
    	}
    }
}
