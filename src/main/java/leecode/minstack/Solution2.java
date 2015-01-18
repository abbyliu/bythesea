package leecode.minstack;

import java.util.Stack;

// v2
public class Solution2 {
	private Stack<Long> data = new Stack<>();
	private long min;

	public void push(int x) {
		if (data.isEmpty()) {
			data.push(0L);
			min = x;
		} else {
			data.push(x - min);
			if (x < min) {
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
			return (int) (value + min);
		} else {
			return (int) min;
		}
	}

	public int getMin() {
		return (int) min;
	}

}
