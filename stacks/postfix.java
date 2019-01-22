package stacks;

import java.util.List;
import java.util.Stack;
import tokens. *;


public class postfix {
	private List<Token> tokens;
	private StackLL<Token> stack;
	
	public postfix(List<Token> ts) {
		this.tokens = ts;
		this.stack = (StackLL<Token>) new StackLL<Token>();
	}
	
	private Token_Num eval_operator (Token op, Token_Num left_operand, Token_Num right_operand) {
	
//		switch (((Token_Op)op).getData()) {
//		case "+":
//			left_operand + right_operand;
//			break;
//		case "-":
//			
//			break;
//		case "*" :
//			//do something
//			break;
//		case "/":
//			//do something
//			break;
//		}
		return null;
	}
//	
//	public Integer eval() {
//		String str;
//		for (Token t: tokens) {
//			if(t.isNumber()) {
//				stack.push(t);
//			}else {
//				Token right_operand = stack.pop();
//				Token left_operand = stack.pop();
//				Token op = t;
//				stack.push(eval_operator(op, (Token_Num)left_operand, (Token_Num right_operand));
//			}
//		}
//	}
	
	public String toInFix() {
		return null;
	}
	
	public static void main(String[] args) {
		
	}
}
