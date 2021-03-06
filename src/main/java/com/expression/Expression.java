package com.expression;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Expression {

	private TreeNode root;

	public Expression(String expression) {
		root = constructTree(infixToPostfix(expression));
	}

	private Queue<Object> infixToPostfix(String expression) {
		if(expression == null || expression.length() == 0) {
			return null;
		}
		
		Queue<Object> postfix = new LinkedList<Object>();
		Stack<Operator> operator = new Stack<Operator>();
		StringBuilder operandBuilder = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if ((ch >= '0' && ch <= '9') || (ch == '.')) { // operand found
				operandBuilder.append(ch);
			} else {
				if(operandBuilder.length() > 0) {
					postfix.add(new Double(operandBuilder.toString()));
					operandBuilder = new StringBuilder();
				}
				Operator currentOperator = OperatorFactory.createOperator(ch);
				while (!operator.isEmpty() && operator.peek().getPrecedence() >= currentOperator.getPrecedence()) {
					postfix.add(operator.pop());
				}
				operator.push(currentOperator);
			}
		}
		if(operandBuilder.length() > 0) {
			postfix.add(new Double(operandBuilder.toString()));
		}
		while (!operator.isEmpty()) {
			postfix.add(operator.pop());
		}

		System.out.println(postfix);

		return postfix;
	}

	private TreeNode constructTree(Queue<Object> postfix) {
		if(postfix == null || postfix.isEmpty()) {
			return null;
		}
		
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode t;

		// Traverse through every entry of postfix Queue
		while (!postfix.isEmpty()) {
			t = new TreeNode(postfix.remove());
			if (t.data instanceof Operator) { // operator
				// Pop two top nodes and make them children
				t.right = st.pop();
				t.left = st.pop();
			}
			// Add this subexpression to stack
			st.push(t);
		}

		// At this time the stack will contain only element which is the root of
		// expression tree
		return st.pop();
	}

	public double evaluate() {
		return evaluate(root);
	}

	private double evaluate(TreeNode t) {
		if (t != null) {
			if (!(t.data instanceof Operator)) {
				return (double) t.data;
			}
			double leftValue = evaluate(t.left);
			double rightValue = evaluate(t.right);

			return ((Operator) t.data).compute(leftValue, rightValue);
		}

		return 0;
	}

}
