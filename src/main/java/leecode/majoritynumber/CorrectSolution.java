package leecode.majoritynumber;

/* Majority Element */
public class CorrectSolution {
	   public int majorityElement(int[] num) {
	        int major = 0;
	        int count = 0;
	        
	        for (int e : num) {
	        	if (count == 0) {
	        		major = e;
	        	}
	        	
	        	if (e == major) {
	        		count++;
	        	} else {
	        		count--;
	        	}
	        }
	        return major;
	    } //voting algo
}
