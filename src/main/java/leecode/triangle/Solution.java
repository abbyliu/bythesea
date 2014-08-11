package leecode.triangle;

import java.util.ArrayList;
import java.util.List;
/*
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if (triangle == null || triangle.size() == 0) return 0;
    	List<List<Integer>> values = new ArrayList<>();
    	List<Integer> rowOne = new ArrayList<>();
    	values.add(rowOne);
    	rowOne.add(triangle.get(0).get(0));
    	for (int i = 1;i < triangle.size(); i++) {
    		List<Integer> next = new ArrayList<>();
    		for (int j = 0; j < triangle.get(i).size(); j++) {
    			next.add(Integer.MAX_VALUE);
    		}
    		List<Integer> previousRow = values.get(i-1);
    		List<Integer> currentRow = triangle.get(i);
    		for (int k = 0; k < previousRow.size();k++) {
    			int value1 = previousRow.get(k) + currentRow.get(k);
    			int value2 = previousRow.get(k) + currentRow.get(k+1);
    			if ( value1 < next.get(k)) {
    				next.set(k, value1);
    			}
    			if (value2 < next.get(k+1)) {
    				next.set(k+1, value2);
    			}
    		}
    		values.add(next);
    	}
    	
    	List<Integer> intt = values.get(triangle.size()-1);
    	int min = Integer.MAX_VALUE;
    	for (int v: intt) {
    		if (v < min) {
    			min = v;
    		}
    	}
    	return min;
    }
}