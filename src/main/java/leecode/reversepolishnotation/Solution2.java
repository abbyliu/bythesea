package leecode.reversepolishnotation;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s.trim());
        } catch(Exception e) {
            return false;
        }
        return true;
    }
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length==0) return 0;
        Deque<Integer> operants = new LinkedList<>();
        
        for (int i = 0; i < tokens.length;i++) {
            if (isInteger(tokens[i]) ) {
                operants.push(Integer.parseInt(tokens[i].trim()));
            } else {
                if (operants.size() >=2) {
                    switch(tokens[i].trim()) {
                      case "+": operants.push(operants.pop()+ operants.pop());break;
                      case "-": operants.push(operants.pop()*-1 + operants.pop());break;
                      case "*": operants.push(operants.pop()*operants.pop());break;
                      case "/": int div = operants.pop();
                                operants.push(operants.pop()/div);break;
                      default: throw new IllegalArgumentException("unsupported operator");
                    }
                } else {
                    throw new IllegalArgumentException("insufficient number");
                }
            }
        }
        if (operants.size() ==1) {
            return operants.pop();
        } else {
            throw new IllegalArgumentException("insufficient operator");
        }
        
    }        
   
}