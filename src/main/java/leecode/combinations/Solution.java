package leecode.combinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n. 
 * O(exponential time)
 */
public class Solution {
	
	public ArrayList<ArrayList<Integer>> combine2(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (n == 0 || k == 0 || k>n) return result;
		Stack<Integer> tmp = new Stack<>();
		findResult(result, n, k, 0, tmp);
		return result;
	}
	
	
    public List<List<Integer>> combine23(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > n) return result;
        List<Integer> tmp = new ArrayList<>();
        findAll(n, k, 1, tmp, result);
        return result;
    }
    private void findAll(int n, int k, int idx, List<Integer> tmp, List<List<Integer>> result) {
        if ( k == 0) {
            List<Integer> ret = new ArrayList<>(tmp);
            result.add(ret);
            return;
        }
        for (int i = idx ; i <= n-k+1; i++) {
            tmp.add(i);
            findAll(n, k-1, i+1, tmp, result);
            tmp.remove(tmp.size()-1);
        }
        
    }
	
	private void findResult(ArrayList<ArrayList<Integer>> result, int n, int k,
			int idx, Stack<Integer> tmp) {
		if (k == 0) {
			ArrayList<Integer> ret = new ArrayList<>(tmp);
			result.add(ret);
			return;
		}
		for (int i = idx+1 ; i <=n;i++) {
			tmp.push(i);
			findResult(result, n, k-1, i, tmp);
			tmp.pop();
		}
	}

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
			if (temp.size() == k)
				result.add(new ArrayList<Integer>(temp));
			else
				dfsWorker(n, k, result, temp, i + 1);
			// remove the elements from temp before return
			temp.remove(temp.size() - 1);
		}
	}
}