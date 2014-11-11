package leecode.findmininroatedarray;

public class Solution2 {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            throw new IllegalArgumentException("num is empty or null");
        }
        int start = 0;
        int end = num.length-1;
        while (start < end && num[start] > num[end]) {
            int mid = (start + end ) / 2;
            if (num[start] > num[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return num[start];
        
    }
}