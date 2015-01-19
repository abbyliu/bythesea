package leecode.nqueens1;

import java.util.ArrayList;
import java.util.List;
/* N-Queens
 * Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, 
where 'Q' and '.' both indicate a queen and an empty space respectively.
O(exponential )
 */
public class Solution {
    public List<String[]> solveNQueens(int n) {
     List<String[]> result = new ArrayList<>();
     if (n <1) return result;
     int[] cols = new int[n];
     placeQueuen(cols, 0, result);
     return result;
    }
    
    public List<String[]> solveNQueens2(int n) {
    	int[] cols = new int[n];
        List<String[]> result = new ArrayList<>();
        int row = 0;
        while (true) {
        	if (row == n) {
        		String[] strs = new String[n];
        		StringBuilder builder = new StringBuilder();
        		for (int i = 0; i < n ; i++) {
        			builder.append(".");
        		}
        		for (int i = 0 ; i < n; i++) {
        			StringBuilder bd = new StringBuilder(builder.toString());
        			bd.setCharAt(cols[i], 'Q');
        			strs[i] = bd.toString();
        		} 
        		result.add(strs);
        		cols[--row]++;
        	} else if (cols[row] == n) {
        		cols[row--] = 0;
        		if (row == -1) break;
        		cols[row]++;
        	} else if (!ok(cols, cols[row], row)) {
                cols[row]++; // problem at this column, so go to next column.
            }
            else row++;   // everything's perfect,
        }
        
        return result;   	
    }

	private boolean ok(int[] col, int c, int idx) {
		for (int i = 0; i < idx; i++)
	            if (col[i] == c || Math.abs(col[i] - c) == Math.abs(i - idx)) 
	                return false;
	    return true;
	}

	private void placeQueuen(int[] cols, int row, List<String[]> result) {
		if (row == cols.length) {
			String[] values = new String[cols.length];
			for (int ii = 0 ;ii < cols.length;ii++) {
				StringBuilder builder = new StringBuilder();
				int v = cols[ii];
				for (int idx = 0; idx < v; idx++) {
					builder.append(".");
				}
				builder.append("Q");
				for (int idx = v+1; idx < cols.length; idx++) {
					builder.append(".");
				}
				values[ii] = builder.toString();
			}
			result.add(values);
			return;
		}
		for (int j = 0 ; j < cols.length; j++) {
			cols[row] = j;
			if (checkRow(row, cols)) {
				placeQueuen(cols, row+1, result);
			}
		}
	}

	private boolean checkRow(int row, int[] cols) {
		for (int i = 0; i < row; i++) {
			int diff = Math.abs(cols[i] - cols[row]);
			if (diff == 0 || diff == row - i) 
				return false;
		}
		return true;
	}
	public static void  main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solveNQueens2(1));
	}
}