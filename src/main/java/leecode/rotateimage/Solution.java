package leecode.rotateimage;

/*
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 */
public class Solution {
    public void rotate(int[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) return;
    	int half = matrix.length/2;
    	int len = matrix.length-1;
    	for (int i = 0 ; i < half; i++) {
    		int diff = i - 0;
    		for (int j = diff; j < len - diff;j++ ) {
    			// top
    			int tmp = matrix[i][j];
    			matrix[i][j] = matrix[len - j][i];
    			matrix[len-j][i] = matrix[len-i][len-j];
    			matrix[len-i][len-j] = matrix[j][len-i];
    			matrix[j][len-i] = tmp;
    		}
    	}
    }
}