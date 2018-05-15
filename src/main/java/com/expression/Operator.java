package com.expression;

public interface Operator {
	
	double compute(double operand1, double operand2);
	
	int getPrecedence();

}
