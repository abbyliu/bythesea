package leecode.maxrectangle;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area. 
 */
public class Solution2 {
	
	public static void main(String[] args) {
		char[][] matrix = new char[][] { {'0','1'}, {'1','0'}};
		Solution2 s = new Solution2();
		s.maximalRectangle3(matrix);
	}
	
	public int maximalRectangle3(char[][] matrix) {
	    if (matrix == null || matrix.length ==0 || matrix[0].length==0) return 0;
	    
	    int[][] height = new int[matrix.length][matrix[0].length+1];
	    for (int i = 0; i < matrix.length;i++) {
	        for (int j = 0 ; j < matrix[i].length;j++) {
	            if (i == 0) {
	                height[i][j] = matrix[i][j] == '1' ? 1:0;
	            } else {
	                height[i][j] = matrix[i][j] == '1' ? height[i-1][j]+ 1:0;
	            }
	        }
	    }
	    
	    int max = 0;
	    for (int i = 0; i < height.length;i++) {
	        max = Math.max(max, findMaxForRow(height[i]));
	    }
	    return max;
    }
    private int findMaxForRow(int[] values) {
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        int idx = 0;
        while (idx < values.length) {
            if (stack.isEmpty() || values[idx] >= values[stack.peek()]) {
                stack.push(idx++);
            } else {
                int v = stack.pop();
                max = Math.max(max, stack.isEmpty()? values[v] * idx: values[v]
                                 * (idx-stack.peek()-1));
            }
        }
        return max;
    }
	
	
	public int maximalRectangle2(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length==0) return 0;
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] dp = new int[n][m+1];
		for (int i = 0; i < n;i++) {
			for (int j = 0; j < m;j++) {
				if (matrix[i][j] == '0') {
					dp[i][j] = 0;
				} else {
					dp[i][j] = i== 0? 1: 1 + dp[i-1][j];
				}
			}
		}
		int maxArea = 0;
		for (int i = 0; i < n; i++) {
			maxArea = Math.max(maxArea, calc(dp[i]));
		}
		return maxArea;
	}
	 private int calc(int[] is) {
		 Stack<Integer> stack = new Stack<>();
		 
		 int idx = 0;
		 int max = 0;
		 while (idx < is.length) {
			 if (stack.isEmpty()|| is[stack.peek()]<= is[idx]) {
				 stack.push(idx++);
			 } else {
				 int v = stack.pop();
				 
				 max = Math.max(max, stack.isEmpty()? is[v] * idx: is[v] * (idx-stack.peek()-1));
			 }
		 }
		return max;
	}
	public int maximalRectangle(char[][] matrix) {
		          int m = matrix.length;
		          int n = m == 0 ? 0 : matrix[0].length;
		          int[][] height = new int[m][n + 1];
		          //actually we know that height can just be a int[n+1], 
		          //however, in that case, we have to write the 2 parts together in row traverse,
		          //which, leetcode just doesn't make you pass big set
		          int maxArea = 0;
		         for(int i = 0; i < m; i++){
		             for(int j = 0; j < n; j++) {
		                 if(matrix[i][j] == '0'){
		                     height[i][j] = 0;
		                 }else {
		                     height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
		                 }
		             }
		         }
		         for(int i = 0; i < m; i++){
		             int area = maxAreaInHist(height[i]);
		             if(area > maxArea){
		                 maxArea = area;
		             }
		         }
		         return maxArea;
		      }
		      
		      private int maxAreaInHist(int[] height){
		          Stack<Integer> stack = new Stack<Integer>();
		          int i = 0;
		          int maxArea = 0;
		          while(i < height.length){
		              if(stack.isEmpty() || height[stack.peek()] <= height[i]){
		                  stack.push(i++);
		              }else {
		                  int t = stack.pop();
		                  maxArea = Math.max(maxArea, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
		              }
		          }
		          return maxArea;
		      }
}
