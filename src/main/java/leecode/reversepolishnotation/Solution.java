package leecode.reversepolishnotation;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
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
	   
	   // fastest
	    public int evalRPN2(String[] tokens) {
	        if (tokens == null || tokens.length ==0) {
	            return 0;
	        }
	        
	        Deque<Integer> params = new LinkedList<>();
	        
	        for (int i = 0; i < tokens.length; i++ ) {
	                switch(tokens[i].trim()) {
	                    case "*": params.push(params.pop() * params.pop()); 
	                              break;
	                    case "+": params.push(params.pop() + params.pop());
	                              break;
	                    case "-": params.push(-1 * params.pop() + params.pop());
	                              break;
	                    case "/": int v = params.pop();
	                              params.push(params.pop()/v);
	                              break;
	                    default:  params.push(new Integer(tokens[i]));
	                              break;
	                }
	        }
	        
	        if (params.size() == 1) {
	            return params.pop();
	        } else {
	            throw new RuntimeException("operator not enough");
	        }
	        
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
