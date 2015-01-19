package leecode.containerwithmostwater;

/* Container With Most Water
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most water. 
 * 
 *  O(n), O(1)
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    public int maxArea(int[] height) {
    	if (height == null || height.length <2 ) return 0;
    	int left = 0;
    	int right = height.length-1;
    	int area = 0;
    	while (left < right) {
        	int lh = height[left];
        	int rh = height[right];
        	area= Math.max(area, Math.min(lh, rh) * (right -left));
        	if (lh <= rh) {
        		while (left < right && height[left] <= lh) {
        			left++;
        		}
        	} else {
        		while (left < right && rh >= height[right]) {
        			right--;
        		}
        	}
    		
    	}
    	return area;
    }

}
