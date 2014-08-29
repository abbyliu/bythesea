package leecode.longestconsective;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
	public int longestConsecutive(int[] num) {
	    
	    if (num == null || num.length==0) return 0;
	    int max = 1;
	    Set<Integer> sets = new HashSet<>();
	    for (int value: num) {
	        sets.add(value);
	    }
	    
	    for (int i = 0; i < num.length;i++) {
	        int v = num[i];
	        int low = v-1;
	        sets.remove(v);
	        while (sets.contains(low)) {
	            sets.remove(low); low--;
	        }
	        int high = v+1;
	        while (sets.contains(high)) {
	            sets.remove(high);high++;
	        }
	        max = Math.max(max, high-low-1);
	        
	    }
	    return max;
	}

}