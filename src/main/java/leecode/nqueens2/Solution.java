package leecode.nqueens2;

/* N-Queens II

 * Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class Solution {
	private int result = 0;
    public int totalNQueens(int n) {
        if (n <1) return result;
        int[] rows = new int[n];
        placeQueuen(rows, 0);
        return result;
        
    }
    
	private void placeQueuen(int[] rows, int row) {
		if (row == rows.length) {
			result++;
			return;
		}
		for (int j = 0 ; j < rows.length; j++) {
			rows[row] = j;
			if (checkRow(row, rows)) {
				placeQueuen(rows, row+1);
			}
		}
	}

	private boolean checkRow(int row, int[] rows) {
		for (int i = 0; i < row; i++) {
			int diff = Math.abs(rows[i] - rows[row]);
			if (diff == 0 || diff == row - i) 
				return false;
		}
		return true;
	}
}