package leecode.setmatrixzeros;
/*
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place. 
 * O(m*N)
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
    	boolean row = false;
    	boolean col = false;
    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = 0; j < matrix[i].length; j++) {
    			if (matrix[i][j] == 0) {
    				matrix[i][0] = 0;
    				matrix[0][j] = 0;
    				if (i == 0) { 
    					row = true;
    				}
    				if (j == 0) {
    					col = true;
    				}
    			}
    		}
    	}
    	for (int i = 1; i < matrix.length; i++ ) {
    		for (int j = 1; j < matrix[i].length; j++) {
    			if (matrix[i][0] == 0 || matrix[0][j] == 0) {
    				matrix[i][j] = 0;
    			}
    		}
    	}
    	if (row)  {
    		for (int i = 0; i < matrix[0].length;i++) {
    			matrix[0][i] = 0;
    		}
    	}
    	if (col) {
    		for (int i = 0; i < matrix.length; i++) {
    			matrix[i][0] = 0;
    		}
    	}
    }
}