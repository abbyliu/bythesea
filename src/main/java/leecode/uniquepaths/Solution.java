package leecode.uniquepaths;
/* Unique Paths
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
O(M*N)
 */
public class Solution {
    public int uniquePaths(int m, int n) {
    	if (m == 0 || n == 0) return 0;
    	if ( m == 1 || n ==1 ) return 1;
    	int[][] paths = new int[m][n];
    	for (int i = 0; i < paths.length;i++) {
    		paths[i][0] = 1;
    	}
    	for (int j = 0; j < paths[0].length; j++) {
    		paths[0][j] = 1;
    	}
    	for (int i = 1; i < paths.length; i++) {
    		for (int j = 1; j < paths[i].length; j++) {
    			paths[i][j] = paths[i-1][j] + paths[i][j-1];
    		}
    	}
    	return paths[m-1][n-1];
    }
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.uniquePaths(3, 3));
    }
}