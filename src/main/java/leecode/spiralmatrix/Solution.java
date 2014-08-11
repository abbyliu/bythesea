package leecode.spiralmatrix;

import java.util.ArrayList;
import java.util.List;
/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5]. 
 */
public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return result;
		int v = matrix.length * matrix[0].length;
		int rowMin = 0, rowMx = matrix.length - 1;
		int colMin = 0, colMx = matrix[0].length - 1;
		while (v > 0) {
			for (int id = colMin; id <= colMx; id++) {
				v--;
				result.add(matrix[rowMin][id]);
			}
			if (v == 0)
				break;
			rowMin++;
			for (int id = rowMin; id <= rowMx; id++) {
				v--;
				result.add(matrix[id][colMx]);
			}
			if (v == 0)
				break;

			colMx--;
			for (int id = colMx; id >= colMin; id--) {
				v--;
				result.add(matrix[rowMx][id]);
			}
			if (v == 0)
				break;

			rowMx--;
			for (int id = rowMx; id >= rowMin; id--) {
				v--;
				result.add(matrix[id][colMin]);
			}
			colMin++;
		}

		return result;
	}
}