package com.calculator;

public class Multiply implements Operator {

	@Override
	public double compute(double operand1, double operand2) {
		return operand1 * operand2;
	}

	@Override
	public int getPrecedance() {
		return 30;
	}

}
