package leecode.suroundedregion;

import java.util.Stack;
/*  Surrounded Regions
 *  Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region. 
O(n2)
 */
public class Solution {
	
    public void solve(char[][] board) {
    	if (board == null|| board.length == 0) return;
    	boolean[][] visited = new boolean[board.length][board[0].length];
    	for (int i = 0; i < board.length; i++) {
    		paint(i, 0, board, visited);
    		paint(i, board[i].length-1, board, visited);
    	}
    	for (int j = 0;j < board[0].length; j++) {
    		paint(0, j, board, visited);
    		paint(board.length-1, j, board, visited);
    	}
    	
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[i].length; j++) {
    			if (board[i][j] == 'K') {
    				board[i][j] = 'O';
    			} else if (board[i][j] == 'O') {
    				board[i][j] = 'X';
    			}
    		}
    	}
    }

	private void paint(int ii, int jj, char[][] board, boolean[][] visited) {
			if (visited[ii][jj]) return;
			if (board[ii][jj] == 'X') return;
			if (board[ii][jj] == 'O') {
				Stack<Node> nodes = new Stack<Node>();
				nodes.add(new Node(ii,jj));
				while (!nodes.isEmpty()) {
					Node n = nodes.pop();
					int i = n.i;
					int j = n.j;
					board[i][j] = 'K';
					visited[i][j] = true;
					
					if (i>0 && !visited[i-1][j] && board[i-1][j] == 'O') {
						nodes.add(new Node(i-1,j));
					}
					if (i< board.length-1 && !visited[i+1][j] && board[i+1][j] == 'O') {
						nodes.add(new Node(i+1,j));
					}
					if (j > 0 && !visited[i][j-1] && board[i][j-1] == 'O') {
						nodes.add(new Node(i, j-1));
					}
					if (j < board[i].length -1 && !visited[i][j+1] && board[i][j+1] == 'O') {
						nodes.add(new Node(i, j+1));
					}
					
				}
			}
	}
	
	static class Node {
		private int i,j;
		Node(int ii , int jj) {
			i = ii;
			j = jj;
	    }
	}
	public static void main(String[] args) {
		char[][] board = new char[][] {{'X','O', 'X','X'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'}};
		Solution s = new Solution();
		s.solve(board);
	}
}
