package leecode.spiralmatrix2;

/*
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,
You should return the following matrix:

[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 0) return result;
        int value = 1;
        int i = 0;
        int j = 0;
        result[0][0] = value;
        while ( value < n*n) {
        	while(available(n, 0, i , j , result)) {
            	value++;
        		j = j+1;
        		result[i][j] = value;
        	} 
        	while (available(n, 1, i, j, result)) {
        		value++;
        		i = i+ 1;
        		result[i][j]= value;
        	} 
        	while (available(n, 2, i, j , result)) {
        		value ++;
        		j =  j -1;
        		result[i][j] = value;
        	} 
        	while (available(n, 3, i, j , result)) {
        		value++;
        		i = i-1;
        		result[i][j]= value;
        	} 
        }
        return result;
    }

	private boolean available(int n, int position, int i, int j, int[][] result) {
		if (position == 0) {
			return j < n-1 && result[i][j+1] == 0;
		} else if (position == 1) {
			return i < n-1 && result[i+1][j] == 0;
		} else if (position == 2) {
			return j > 0 && result[i][j-1] == 0;
		} else {
			return i > 0 && result[i-1][j] == 0;
		}
	}
}