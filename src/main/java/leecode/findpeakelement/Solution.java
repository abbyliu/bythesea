package leecode.findpeakelement;

public class Solution {
    public int findPeakElement(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int start = 0;
        int end = num.length-1;
        while (start < end) {
            int mid = (start+end)/2;
            if (mid == start) {
                return num[mid] > num[end]? mid:end;
            }
            if ( (mid ==0 || num[mid-1] < num[mid])
                 &&(mid == end || num[mid] > num[mid+1])) {
                     return mid;
            }
            if (num[mid-1] > num[mid]) {
                end = mid;
            } else if (num[mid+1] > num[mid]) {
                start = mid + 1;
            }
            
            
        }
        return start;
    }
}