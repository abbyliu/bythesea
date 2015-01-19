package leecode.triangle;

import java.util.List;
/* Triangle
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
O(n2)
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        List<Integer> last = triangle.get(triangle.size()-1);
        int[] result = new int[last.size()];
        for (int i = 0; i < result.length;i++) {
            result[i] = last.get(i);
        }
        for (int i = last.size()-1; i>0;i--) {
            List<Integer> row = triangle.get(i-1);
            for (int j = 0; j < i;j++) {
                result[j] = row.get(j) + Math.min(result[j], result[j+1]);
            } 
        }
        return result[0];
    }
}