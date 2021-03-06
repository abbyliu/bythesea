package leecode.mergesortedarray;

/*
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
The number of elements initialized in A and B are m and n respectively.
O(m+n)
 */
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = new int[1];
		int[] B = {1};
		s.merge(A, 0, B, 1);
	}
    public void merge(int A[], int m, int B[], int n) {
    	if (A == null || B == null) return;
    	if (A.length < m + n) return;
    	int i = m-1;
    	int j = n-1;
    	int k = m+n-1;
    	while (i >= 0 && j >=0) {
    		if (A[i] < B[j]) {
    			A[k--] = B[j--];
    		}  else {
    			A[k--] = A[i--];
    		}
    	}
    	while (j>=0) {
    		A[k--] = B[j--];
    	}
    }
}