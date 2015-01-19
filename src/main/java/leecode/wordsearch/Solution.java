package leecode.wordsearch;
/*  Word Search
 *  Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are 
those horizontally or vertically neighboring. The same letter cell may not be 
O(exp)
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
    	if (board == null || board.length == 0 ) return false;
    	if (word == null) return false;
    	if (board[0].length == 0) {
    		if (word.length() == 0) return true;
    		else return false;
    	}
    	boolean[][] used = new boolean[board.length][board[0].length];
    	
    	for (int i = 0; i < board.length; i++) {
    		for (int j= 0; j < board[i].length; j++) {
    			if (check(board, used, i, j, word)) {
    				return true;
    			}
    		}
    	}
    	return false;
    }

	private boolean check(char[][] board, boolean[][] used, int i, int j,
			String word) {
		if (word.charAt(0) != board[i][j]) {
			return false;
		}
		if (word.length() == 1 ) {
			return true;
		} else {
			used[i][j] = true;
			if (i>0 && !used[i-1][j]) {
				boolean up = check(board, used, i-1,j, word.substring(1));
				if (up) return true;
			}
			if (i < board.length-1 && !used[i+1][j]) {
				boolean down = check(board, used, i+1,j, word.substring(1));
				if (down) return true;
			}
			if ( j > 0 && !used[i][j-1]) {
				boolean left = check(board, used, i, j-1, word.substring(1));
				if (left) return true;
			}
			if (j < board[i].length -1 && !used[i][j+1]) {
				boolean right = check(board, used, i, j+1, word.substring(1));
				if (right) return true;
			}
			used[i][j] = false;
			return false;
		}
		
	}
}