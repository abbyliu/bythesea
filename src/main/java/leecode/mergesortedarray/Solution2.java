package leecode.mergesortedarray;

public class Solution2 {
    public void merge(int A[], int m, int B[], int n) {
        if (m+n > A.length) return;
        
        int idx = m+n-1;
        int i = m-1;
        int j = n-1;
        while (i>=0 && j>=0) {
            if (A[i] > B[j]) {
                A[idx--] = A[i--];
            } else {
                A[idx--] = B[j--];
            }
        }
        while (j >=0 ) {
            A[idx--] = B[j--];
        }
    }
}