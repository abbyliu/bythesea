package leecode.minpathsum;
/* Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
O(m*n), space can be optimized to O(n)
 */
public class Solution {
	
	public int minPathSum2(int[][] grid) {
		if (grid == null || grid.length == 0|| grid[0].length ==0) return 0;
		int[][] v = new int[grid.length][grid[0].length];
		v[0][0] = grid[0][0];
		for (int i = 1; i < grid.length;i++) {
			v[i][0] = grid[i][0] + v[i-1][0]; 
		}
		for (int j = 1; j < grid[0].length;j++) {
			v[0][j]  = grid[0][j] + v[0][j-1];
		}
		for (int i = 1; i < grid.length;i++) {
			for (int j = 1; j < grid[i].length; j++) {
				v[i][j] = grid[i][j] + Math.min(v[i-1][j], v[i][j-1]);
			}
		}
		return v[grid.length-1][grid[0].length-1];
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] grid = {{1,2},{1,1}};
		s.minPathSum2(grid);
	}
	
}