package com.expression;

public class Add implements Operator {

	@Override
	public double compute(double operand1, double operand2) {
		return operand1 + operand2;
	}

	@Override
	public int getPrecedence() {
		return 20;
	}

}
