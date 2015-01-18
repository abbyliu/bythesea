package leecode.minstack;

import java.util.Stack;

/* Min Stack */
// v1
public class MinStack {
    static class Mark {
        private int value;
        private int count;
        public Mark(int v, int c) {
            value = v;
            count = c;
        }
    }
    
    private Stack<Integer> data = new Stack<>();
    private Stack<Mark> min = new Stack<>();
    
    public void push(int x) {
        data.push(x);
        if (min.isEmpty() || x < getMin()) {
            min.push(new Mark(x,1));
        } else if (x == getMin()) {
            min.peek().count = min.peek().count+1;
        }
    }

    public void pop() {
        int value = data.pop();
        if (value == getMin()) {
            min.peek().count = min.peek().count - 1;
            if (min.peek().count == 0) {
                min.pop();
            }
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek().value;
    }
}

