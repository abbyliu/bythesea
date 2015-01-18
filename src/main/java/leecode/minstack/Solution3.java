package leecode.minstack;

import java.util.Deque;
import java.util.LinkedList;

// v3
public class Solution3 {
	static class MinStack3 {
		  private Deque<Integer> data = new LinkedList<>();
		  private Deque<Integer> min = new LinkedList<>();
		  
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
	
	public static void main(String[] args) {
		MinStack3 stack = new MinStack3();
	 	stack.push(-2);
	 	stack.push(0);
	 	stack.push(-1);
	 	System.out.println(stack.getMin());
	 	System.out.println(stack.top());
	 	stack.pop();
	 	System.out.println(stack.getMin());
	}
}
