package leecode.combinations;

import java.util.ArrayList;
/* Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n. 
 * O(exponential time)
 */
public class Solution {

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (n <= 0 || k <= 0)
			return result;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		dfsWorker(n, k, result, temp, 1);
		return result;
	}

	public void dfsWorker(int n, int k, ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> temp, int currentPosition) {
		for (int i = currentPosition; i <= n; i++) {
			temp.add(i);
			if (temp.size() == k) {
				result.add(new ArrayList<Integer>(temp));
			}
			else {
				dfsWorker(n, k, result, temp, i + 1);
			}
			// remove the elements from temp before return
			temp.remove(temp.size() - 1);
		}
	}
}