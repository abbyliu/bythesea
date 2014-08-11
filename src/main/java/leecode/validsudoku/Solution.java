package leecode.validsudoku;

/*
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isValidSudoku(char[][] board) {
    	if (board == null || board.length != 9 || board[0].length != 9) return false;
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
    			if (board[i][j] != '.' && !check(board[i][j]-'0', board, i,j)) {
    				return false;
    			}
    		}
    	}
    	return true;
    }

	private boolean check(int value, char[][] board, int ii, int jj) {
		for (int idx = 0; idx < 9; idx ++) {
			if (idx != ii) {
				if (board[idx][jj] - '0' == value) {
					return false;
				}
			}

			if (idx != jj) {
				if (board[ii][idx] - '0' == value) {
					return false;
				}
			}
		}
		int rgroup = ii/3;
		int cgroup = jj/3;
		
		for (int i = 0 + rgroup * 3; i < 3 + rgroup*3 ; i++) {
			for (int j = 0 + cgroup * 3; j < 3 + cgroup * 3 ;j++) {
				if (i != ii || j != jj) {
					if (board[i][j] - '0' == value) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
