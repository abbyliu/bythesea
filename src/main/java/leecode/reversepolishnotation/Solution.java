package leecode.reversepolishnotation;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * Key takeaway:
 * 1. Orders in the polish matters
 */

/*
 *  Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
 */
public class Solution {
	
    public int evalRPN2(String[] tokens) {
        if (tokens == null|| tokens.length == 0) return 0;
        Stack<Integer> operands = new Stack<>();
        boolean valid = true;
        for (int i = 0; i < tokens.length && valid; i++) {
          String str = tokens[i];
          if (isInteger2(str)) {
              operands.push(Integer.parseInt(str));
          } else {
              valid = checkOperants(2, operands);
              if (valid) {
                  int v2 = operands.pop();
                  int v1 = operands.pop();
                  switch(str) {
                     case "+": operands.push(v1+v2);
                               break;
                     case "-": operands.push(v1-v2);
                               break;
                     case "*" : operands.push(v1*v2);
                               break;
                     case "/": operands.push(v1/v2);
                               break;
                     default:  valid = false;
                  }
              }
         }
        }
        if (valid && operands.size() == 1) {
            return operands.pop();
        } else {
           return 0;
        }
      }
	
    private boolean checkOperants(int expected, Stack<Integer> operands) {
        return operands.size() >= expected;
    }
    private boolean isInteger2(String s) {
        boolean result = false;
        try {
            Integer.parseInt(s);
            result = true;
        } catch(NumberFormatException e) {
            ;// ignore
        }
        return result;
    }
    
	
	   private static Set<String> operators = new HashSet<String>();
	   static {
		   operators.add("+");
		   operators.add("-");
		   operators.add("*");
		   operators.add("/");
	   }

	   private boolean isOperator(String s)  {
		   return operators.contains(s);
	   }
	   
	   private boolean isInteger(String s) {
		   try {
			   Integer.parseInt(s);
			   return true;
		   } catch(Exception e) {
			   return false;
		   }
	   }
	   
	   private int calc(int op2, int op1, String oper) {
		   switch (oper) {
		   	  case "+": return op1+op2;
		   	  case   "-": return op1-op2;
		   	  case   "*": return op1*op2;
		      default: return op1/op2;
		   }
	   }
	   
	   public int evalRPN(String[] tokens) {
		   int result = 0;
		   if (tokens != null && tokens.length > 0) {
			   Stack<Integer> processor = new Stack<Integer>();
			   for (int i = 0; i < tokens.length ; i++) {
				   if (isInteger(tokens[i])) {
					   processor.push(Integer.parseInt(tokens[i]));
				   } else if (isOperator(tokens[i])) {
					   if (processor.size() < 2) {
						   throw new IllegalArgumentException("not enough operrant");
					   } else {
						   processor.push(calc(processor.pop(), processor.pop(),tokens[i]));
					   }
				   } else {
					   throw new IllegalArgumentException("invalid input value");
				   }
			   }
			   if (processor.size()!= 1) {
				   throw new IllegalArgumentException("invalid input data");
			   } else {
				   return processor.pop();
			   }
		   }
		   return result;
	   }
	   
	   public static void main(String[] args) {
		   String[] input = {"2", "1", "+", "3", "*"};
		   Solution solution = new Solution();
		   int result = solution.evalRPN(input);
		   System.out.println(result);
		   String[] input2 = {"0", "3", "/"};
		   result = solution.evalRPN(input2);
		   System.out.println(result);
	   }
}
