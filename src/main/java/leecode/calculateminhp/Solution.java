package leecode.calculateminhp;

/* Dungeon Game */
/* O(M*N) memory
 * O(M*N) time
 */
public class Solution {

	   public int calculateMinimumHP(int[][] dungeon) {
	        int row = dungeon.length;
	        int col = dungeon[0].length;
	        int health[][] = new int[row][col];

	        // 1. when the knight reached the bottom right corner
	        health[row-1][col-1] = (dungeon[row-1][col-1] > 0) ? 1 : (1 - dungeon[row-1][col-1]);

	        // 2. in the last column, bottom-up;
	        for(int i = row - 2; i >= 0; --i) {
	            int aboveValue = health[i+1][col-1] - dungeon[i][col-1];
	            health[i][col-1]  = aboveValue > 0 ? aboveValue : 1;
	        }

	        // 3. in the last row, from right to left
	        for(int j = col - 2; j >= 0; --j) {
	            int leftValue = health[row-1][j+1] - dungeon[row-1][j];
	            health[row-1][j]  = leftValue > 0 ? leftValue : 1;
	        }

	        // 4. in other areas, from bottom-right to upper-left
	        for(int i = row - 2; i >=0; --i) {
	            for(int j = col - 2; j >= 0; --j) {
	                int rightValue = (health[i][j+1]-dungeon[i][j] > 0) ? health[i][j+1]-dungeon[i][j] : 1;
	                int belowValue = (health[i+1][j]-dungeon[i][j] > 0) ? health[i+1][j]-dungeon[i][j] : 1;
	                health[i][j] = Math.min(rightValue, belowValue);
	            }
	        }
	        return health[0][0];
	    }
	
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[][] test = new int[][]{{10,4,-48,-8,-87,9},{49,-100,6,-15,41,-99},{-76,-45,-26,50,46,14},{-81,-92,46,-62,-26,1},{-44,19,26,-98,-49,-72}};
    	s.calculateMinimumHP(test);
    }
}