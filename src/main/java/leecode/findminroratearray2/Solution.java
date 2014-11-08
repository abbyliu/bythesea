package leecode.findminroratearray2;

public class Solution {
    public int findMin(int[] num) {
        int start = 0;
        int end = num.length-1;
        while (start < end) {
            int mid = start + (end-start)/2;
            if (mid == start) {
                break;
            }
            if (num[start] > num[mid]) {
                end = mid;
            } else if (num[start] == num[mid]) {
                start++;
            } else {
                if (num[start] >= num[end]) {
                    start = mid+1;
                } else {
                    return num[start];
                }
            }
        }
        return Math.min(num[start], num[end]);
        
    }
}