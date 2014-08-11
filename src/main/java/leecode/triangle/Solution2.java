package leecode.triangle;

import java.util.List;

public class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if (triangle == null || triangle.size() == 0) return 0;
    	List<Integer> lastRow = triangle.get(triangle.size()-1);
    	int[] last = new int[triangle.get(triangle.size()-1).size()];
    	for (int i = 0; i < last.length; i++) {
    		last[i] = lastRow.get(i);
    	}
    	
    	for (int j = triangle.size()-2; j >=0; j--) {
    		List<Integer> row = triangle.get(j);
    		for (int i = 0; i <= j; i++) {
    			last[i] = Math.min(last[i], last[i+1]) + row.get(i);
    		}
    	}
    	return last[0];
    }

}
