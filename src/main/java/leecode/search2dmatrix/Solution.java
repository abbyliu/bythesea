package leecode.search2dmatrix;

/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

O(logm*n)
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix == null || matrix.length == 0) return false;
    	int startRow = 0;
    	int endRow = matrix.length -1;
    	while (startRow < endRow) {
    		int midRow = startRow + (endRow -startRow)/2;
    		int lastV = matrix[midRow][matrix[midRow].length-1];
    		if (lastV == target) {
    			return true;
    		} else if (lastV < target) {
    			startRow = midRow +1;
    		} else {
    			endRow = midRow;
    		}
    	}
    	
    	int startP = 0;
    	int endP = matrix[endRow].length -1;
    	while (startP <= endP) {
    		int mid = startP + (endP - startP)/2;
    		int midV = matrix[endRow][mid];
    		if (midV == target) {
    			return true;
    		} else if (midV < target) {
    			startP = startP + 1;
    		} else {
    			endP = mid -1;
    		}
    	}
    	return false;
    }
}