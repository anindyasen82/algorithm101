package com.calculator;

public interface Operator {
	
	public double compute(double operand1, double operand2);
	
	public int getPrecedance();

}
