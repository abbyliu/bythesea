package leecode.triangle;

import java.util.List;

public class Solution4 {
	   public int minimumTotal(List<List<Integer>> triangle) {
	        if (triangle == null || triangle.size() == 0) {
	            return 0;
	        }
	        int[] buff = new int[triangle.size()];
	        for (int i = 0; i < buff.length; i++) {
	            buff[i] = triangle.get(triangle.size()-1).get(i);
	        }
	        
	        for (int i = 0; i < triangle.size()-1; i++) {
	            for (int j = 0; j < triangle.size()-1-i; j++) {
	                buff[j] = Math.min(buff[j], buff[j+1]) +
	                            triangle.get(triangle.size()-1-i-1).get(j);
	            }
	        }
	        
	        return buff[0];
	    }
}
