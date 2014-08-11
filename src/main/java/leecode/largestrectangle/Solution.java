package leecode.largestrectangle;

import java.util.Arrays;
import java.util.Stack;
/*
 * Given n non-negative integers representing the histogram's 
 * bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * O(n)
 * O(1) 
 */
public class Solution {
	public static void main(String[] args) {
		 
        int[] height = {4,2,0,3,2,5};
        Solution s = new Solution();
        s.largestRectangleArea2(height);
	}
	public int largestRectangleArea2(int[] height) {
		Stack<Integer> stack = new Stack<>();
		int i = 0; 
		int maxArea = 0;
		int[] h = new int[height.length+1];
		h = Arrays.copyOf(height,  height.length+1);
		while (i < h.length) {
			if (stack.isEmpty()|| h[stack.peek()]<=h[i]) {
				stack.push(i++);
			} else {
				int t = stack.pop();
				maxArea = Math.max(maxArea, h[t] * (stack.isEmpty()? i: i-stack.peek()-1));
			}
		}
		return maxArea;
	}
	public int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int maxArea = 0;
		int[] h = new int[height.length + 1];
		h = Arrays.copyOf(height, height.length + 1);
		while (i < h.length) {
			if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
				stack.push(i++);
			} else {
				int t = stack.pop();
				maxArea = Math.max(maxArea, h[t]
						* (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}
		return maxArea;
	}
}
