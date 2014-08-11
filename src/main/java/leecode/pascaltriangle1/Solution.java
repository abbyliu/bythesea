package leecode.pascaltriangle1;

import java.util.ArrayList;
import java.util.List;
/*
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> returns = new ArrayList<>();
    	if (numRows < 0) return returns;
    	List<Integer> first = new ArrayList<>();first.add(1);
    	returns.add(first);
    	for (int i = 1 ; i < numRows;i++) {
    		List<Integer> newRow = new ArrayList<>();
    		newRow.add(1);
    		List<Integer> previous = returns.get(i-1);
    		for (int j = 1;j < i;j++) {
    			newRow.add(previous.get(j-1) + previous.get(j));
    		}
    		newRow.add(1);
    		returns.add(newRow);
    	}
    	return returns;
    } 
}
