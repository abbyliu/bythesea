package leecode.uniquepath2;
/* Unique Paths II
 * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if (m == 0 || n == 0 || obstacleGrid[m-1][n-1] == 1) return 0;
    	
    	int[][] paths = new int[m][n];
    	paths[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
    	
    	for (int i = 1; i < paths.length;i++) {
    		paths[i][0] = obstacleGrid[i][0] == 1 ? 0 : paths[i-1][0];
    	}
    	for (int j = 1; j < paths[0].length; j++) {
    		paths[0][j] = obstacleGrid[0][j] == 1 ? 0 : paths[0][j-1];
    	}
    	
    	for (int i = 1; i < paths.length; i++) {
    		for (int j = 1; j < paths[i].length; j++) {
    			paths[i][j] = obstacleGrid[i][j] == 1 ? 0 : paths[i-1][j] + paths[i][j-1];
    		}
    	}
    	return paths[m-1][n-1];
    }
}