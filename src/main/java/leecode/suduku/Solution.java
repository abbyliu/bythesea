package leecode.suduku;

import java.util.ArrayList;
import java.util.List;
/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * O(exp)
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public void solveSudoku(char[][] board) {
    	if (board == null || board.length != 9 || board[0].length != 9) return;
    	List<Node> nodes = new ArrayList<>();
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
    			if (board[i][j] == '.')
    				nodes.add(new Node(i,j));
    		}
    	}
    	solvePuzzle(board, nodes);
    }
    private boolean solvePuzzle(char[][] board, List<Node> nodes) {
    	if (nodes.size() == 0) {
    		return true;
    	}
    	Node n = nodes.remove(0);
    	for (int i = 1; i <=9; i++) {
    		if (check(i, board, n)) {
    			board[n.i][n.j] = String.valueOf(i).charAt(0);
    			boolean result = solvePuzzle(board, new ArrayList<>(nodes));
    			if (result) return true;
    			board[n.i][n.j] = '.';
    		}
    	}
    	return false;
	}
	private boolean check(int value, char[][] board, Node n) {
		for (int idx = 0; idx < 9; idx ++) {
			if (board[idx][n.j] - '0' == value) {
				return false;
			}
			if (board[n.i][idx] - '0' == value) {
				return false;
			}
		}
		int rgroup = n.i/3;
		int cgroup = n.j/3;
		
		for (int i = 0 + rgroup * 3; i < 3 + rgroup*3 ; i++) {
			for (int j = 0 + cgroup * 3; j < 3 + cgroup * 3 ;j++) {
				if (board[i][j] - '0' == value) {
					return false;
				}
			}
		}
		
		return true;
	}
	static class Node {
    	public int i;
    	public int j;
    	public Node(int ii, int jj) {
    		i = ii
    	;j = jj;
    	}
    }
    
}
