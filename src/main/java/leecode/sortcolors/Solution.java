package leecode.sortcolors;
/*
 *  Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.
 */
public class Solution {
    public void sortColors(int[] A) {
    	if (A == null ||A.length <2) return ;
        int red = 0;
        int blue = A.length-1;
        int idx = 0;
        while (idx < blue+1) {
        	if (A[idx] == 0) {
        		swap(A, idx, red);
        		idx++;
        		red++;
        		continue;
        	}
        	if (A[idx] == 2) {
        		swap(A, idx, blue);
        		blue--;
        		continue;
        	}
        	idx++;
        }
    }
    private void swap(int[] a, int idx, int red) {
    	if (idx != red) {
    		int tmp = a[idx];
    		a[idx] = a[red];
    		a[red]= tmp;
    	}
	}
	public static void main(String[] args) {
    	Solution s= new Solution();
    	int[] A= {2,0};
    	s.sortColors(A);
    }
}