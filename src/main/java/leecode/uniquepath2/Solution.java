package leecode.uniquepath2;
/*
 * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
    	int m= obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	int[][] paths = new int[m][n];
    	boolean blocked = false;
    	for (int i = 0; i < paths.length;i++) {
    		if (obstacleGrid[i][0] == 1) {
    			blocked = true;
    		}
    		if (!blocked)
    			paths[i][0] = 1;
    		else 
    			paths[i][0] = 0;
    	}
    	blocked = false;
    	for (int j = 0; j < paths[0].length; j++) {
    		if (obstacleGrid[0][j] == 1) {
    			blocked = true;
    		}
    		if (!blocked)
    			paths[0][j] = 1;
    		else 
    			paths[0][j] = 0;
    	}
    	for (int i = 1; i < paths.length; i++) {
    		for (int j = 1; j < paths[i].length; j++) {
    			if (obstacleGrid[i][j] == 1) {
    				paths[i][j] = 0;
    			} else {
    				paths[i][j] = paths[i-1][j] + paths[i][j-1];
    			}
    		}
    	}
    	return paths[m-1][n-1];
   	
    }
}