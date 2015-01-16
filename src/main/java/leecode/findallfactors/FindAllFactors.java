package leecode.findallfactors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAllFactors {
	public static void findAllFactors(int value) {
		Map<Integer, Integer> counts = new HashMap<>();
		
		counts.put(1, 1);
		int sqrt = (int) Math.sqrt(value);
		for (int i = 2, k = 0; i <= sqrt && value >1; k++, i= 2 * k +1) {
			while (value % i ==0 && value > 1) {
				if (counts.containsKey(i)) {
					counts.put(i, counts.get(i)+1);
				} else {
					counts.put(i, 1);
				}
				value = value / i;
			}
		}
		if (value != 1) {
			counts.put(value, 1);
		}
		
		StringBuilder builder = new StringBuilder();
		Integer[] keys = counts.keySet().toArray(new Integer[0]);
		Arrays.sort(keys);
		for (Integer inte: keys) {
			if (builder.length() > 0) {
				builder.append("*");
			}
			builder.append(inte);
			if (counts.get(inte) >1) {
				builder.append("^").append(counts.get(inte));
			}
		}
		System.out.println(builder.toString());
	}
	
	public static void main(String[] args) {
		findAllFactors(1024);
		findAllFactors(15);
	}
}
