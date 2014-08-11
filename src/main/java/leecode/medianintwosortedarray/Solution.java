package leecode.medianintwosortedarray;
/*
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {};
		int[] B  = {1,2,3,4,5};
		Solution s = new Solution();
		s.findMedianSortedArrays2(A, B);
	}

	public double findMedianSortedArrays2(int A[], int B[]) {
		if (A == null || B== null) return 0;
		int n = A.length;
		int m = B.length;
		if ((m+n)%2 ==1) {
			return findKthElement(A, B, (m+n)/2, 0, n-1, 0, m-1);
		} else {
			return (findKthElement(A, B, (m+n)/2, 0, n-1, 0, m-1)
			+ findKthElement(A, B, (m+n)/2-1, 0, n-1, 0, m-1))*0.5; 
		}
	}
	private double findKthElement(int[] a, int[] b, int k, int startA, int endA, int startB,
			int endB) {
		int aLen = endA - startA+1;
		int bLen = endB- startB+1;
		if (aLen == 0) {
			return b[startB+k];
		}
		if (bLen == 0) {
			return a[startA+k];
		}
		if (k == 0) {
			return a[startA] < b[startB]? a[startA]:b[startB];
		}
		
		int aMid = aLen * k/(aLen + bLen);
		int bMid = k - aMid -1;
		
		aMid += startA;
		bMid += startB;
		
		if (a[aMid] > b[bMid]) {
			k = k - (bMid-startB+1);
			startB = bMid + 1;
			endA = aMid;
		} else {
			k = k - (aMid - startA+1);
			startA = aMid +1;
			endB = bMid;
		}
		
		return findKthElement(a, b, k, startA, endA, startB, endB);
	}

	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;

		if ((m + n) % 2 != 0) // odd
			return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
		else { // even
			return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) + findKth(A,
					B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
		}
	}

	public int findKth(int A[], int B[], int k, int aStart, int aEnd,
			int bStart, int bEnd) {

		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;

		// Handle special cases
		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		if (k == 0)
			return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

		int aMid = aLen * k / (aLen + bLen); // a's middle count
		int bMid = k - aMid - 1; // b's middle count

		// make aMid and bMid to be array index
		aMid = aMid + aStart;
		bMid = bMid + bStart;

		if (A[aMid] > B[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}

		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}
}
