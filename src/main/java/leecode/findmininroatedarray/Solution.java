package leecode.findmininroatedarray;

public class Solution {
    public int findMin(int[] num) {
        int start = 0;
        int end = num.length-1;
        while (start < end) {
            int mid = start + (end-start)/2;
            if (num[start] > num[mid]) {
                end = mid;
            } else {
                if (num[start] > num[end]) {
                    start = mid+1;
                } else {
                    return num[start];
                }
            }
        }
        return Math.min(num[start], num[end]);
        
    }
}
