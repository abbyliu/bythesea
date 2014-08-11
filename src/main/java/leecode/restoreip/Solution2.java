package leecode.restoreip;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	    public List<String> restoreIpAddresses(String s) {
	    	List<String> result = new ArrayList<>();
	    	for (int i = 1; i < 4 && i < s.length(); i++) {
	    		String first = s.substring(0, i);
	    		if (!isValid(first)) continue;
	    		for (int j = i+1; j < i + 4 && j < s.length(); j++) {
	    			String second = s.substring(i, j);
	    			if (!isValid(second)) continue;
	    			for (int k = j+1; k < j+4 && k < s.length(); k++) {
	    				String third = s.substring(j, k);
	    				String fourth = s.substring(k);
	    				if (isValid(third) && isValid(fourth)) {
	    					String ss = first + "." + second + "." + third + "." + fourth;
	    					result.add(ss);
	    				}
	    			}
	    		}
	    	}
	    	return result;
	    }

		private boolean isValid(String first) {
		    if (first.length() <= 0 || first.length() > 3) return false;
			int v = Integer.parseInt(first);
			if (v > 255 || v < 0) return false;
			if (!first.equals(String.valueOf(v)))
				return false;
			return true;
		}

		public static void main(String[] args) {
			Solution2 s = new Solution2();
			System.out.println(s.restoreIpAddresses("0000"));
			
		}
}
