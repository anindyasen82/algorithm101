package com.excel;

import java.util.Stack;

public class ColumnNameGenerator {

	public String generate(int columnIndex) {
		Stack<Character> columnName = getColumnChars(columnIndex);
		StringBuilder columnNameBuilder = new StringBuilder();
		while(!columnName.isEmpty()) {
			columnNameBuilder.append(columnName.pop());
		}
		return columnNameBuilder.toString();
	}

	private Stack<Character> getColumnChars(int columnIndex) {
		Stack<Character> columnName = new Stack<Character>();
		while (columnIndex > 0) {
			// Find remainder
			int remainder = columnIndex % 26;

			// If remainder is 0, then a 'Z' must be there in output
			if (remainder == 0) {
				columnName.push('Z');
				columnIndex = (columnIndex / 26) - 1;
			} else { // If remainder is non-zero
				columnName.push((char) ((remainder - 1) + 'A'));
				columnIndex = columnIndex / 26;
			}
		}
		return columnName;
	}

}
