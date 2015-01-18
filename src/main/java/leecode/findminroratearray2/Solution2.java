package leecode.findminroratearray2;

/* Find Minimum in Rotated Sorted Array II
 * 
 * as long as left >= right, that mean the array is rotated
 */
public class Solution2 {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            throw new RuntimeException("input array is null or empty") ;
        }
        int left = 0;
        int right = num.length-1;
        while (left < right && num[left] >= num[right]) {
            int mid = (left + right) / 2;
            if ( num[left] > num[mid]) {
                right = mid;
            } else if ( num[left] < num[mid] ) {
                left = mid + 1;
            } else {
                left = left + 1;
            }
        }
        return num[left];
    }
}