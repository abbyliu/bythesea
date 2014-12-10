package leecode.minstack;

import java.util.Stack;

public class Solution3 {
	class MinStack {
	    private Stack<Long> data = new Stack<>();
	    private long min;
	    
	    public void push(int x) {
	    	if (data.isEmpty()) {
	    		data.push(0L);
	    		min = x;
	    	} else {
    			data.push(x - min);
	    		if ( x < min) {
	    			min = x;
	    		}
	    	}
	    }

	    public void pop() {
	        long value = data.pop();
	        if (value < 0) {
	        	min = min - value;
	        }
	    }

	    public int top() {
	    	long value = data.peek();
	    	if (value > 0) {
	    		return (int)(value + min);
	    	} else {
	    		return (int)min;
	    	}
	    }

	    public int getMin() {
	        return (int) min;
	    }
	}
	
	class MinStack2 {
		  private Stack<Integer> data = new Stack<>();
		  private Stack<Integer> min = new Stack<>();
		  
		  public void push(int x) {
		     data.push(x);
		     if (min.size() == 0 || x <= min.peek()) {
		         min.push(x);
		     }
		  }
		  
		  public void pop() {
		      int x = data.pop();
		      if (x == min.peek()) {
		          min.pop();
		      }
		  }
		  public int top() {
		      return data.peek();
		  }
		  
		  public int getMin() {
		      return min.peek();
		  }
		}

}
