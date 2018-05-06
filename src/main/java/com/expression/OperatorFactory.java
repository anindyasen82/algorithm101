package com.expression;

public class OperatorFactory {
	
	public static Operator createOperator(char c) {
		Operator operator = null;
		switch (c) {
			case '+':
				operator = new Add();
				break;
				
			case '-':
				operator = new Subtract();
				break;
				
			case '*':
				operator = new Multiply();
				break;
				
			case '/':
				operator = new Divide();
				break;
	
			default:
				throw new RuntimeException("Unsupported operator");
		}
		
		return operator;
	}

}
