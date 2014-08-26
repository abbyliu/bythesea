package eopi.c1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MinimumExpression {
	public List<Integer> getMinimumExp(int n) {
		List<Integer> inte = new ArrayList<>();
		if (n == 1) {
			inte.add(1);
			return inte;
		}
		Deque<List<Integer>> q = new LinkedList<>();
		inte.add(1);
		q.offer(inte);
		while (!q.isEmpty()) {
			List<Integer> l = q.poll();
			for (int i= 0; i < l.size();i++) {
				int sum = l.get(i) + l.get(l.size()-1);
				if (sum > n) break;
				
				List<Integer> newL = new ArrayList<>(l);
				newL.add(sum);
				if (sum == n) {
					System.out.println("total lists in queue: " + q.size());
					return newL;
				}
				q.offer(newL);
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.putAll(null);
		MinimumExpression exp = new MinimumExpression();
		List<Integer> result = exp.getMinimumExp(15);
		System.out.println(result);
	}
}
