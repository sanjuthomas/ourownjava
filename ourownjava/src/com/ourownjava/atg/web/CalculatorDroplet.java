package com.ourownjava.atg.web;

import java.io.IOException;

import javax.servlet.ServletException;

import atg.core.util.StringUtils;
import atg.nucleus.naming.ParameterName;
import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;
import atg.servlet.DynamoServlet;

/**
 * @author ourownjava.com
 * @date June 9th, 2012
 * 
 *  How to write a custom droplet in ATG
 * 
 */

public class CalculatorDroplet extends DynamoServlet {
	private static final String OPERANDS = "operands";
	private static final String OPERATOR = "operator";
	private static final String ADD = "+";
	private static final String SUB = "-";
	private static final String MUL = "*";
	private static final String OPERAND_DELIMITER = ",";
	private static final String SPACE = " ";
	private static final String EQUALS = "=";
	private static final String RESULT = "result";
	private static final ParameterName OUTPUT = ParameterName
			.getParameterName("output");

	@Override
	public void service(final DynamoHttpServletRequest request,
			final DynamoHttpServletResponse response) throws ServletException,
			IOException {
		final String operands = request.getParameter(OPERANDS);
		final String operator = request.getParameter(OPERATOR);
		if (StringUtils.isEmpty(operands) || StringUtils.isEmpty(operator)) {
			throw new IllegalArgumentException(
					"Operands & Operator can't be null or empty. Operator ->"
							+ operator + " Operands ->" + operands);
		}
		final String[] tempOperands = operands.split(OPERAND_DELIMITER);
		if (tempOperands.length != 2) {
			throw new IllegalArgumentException(
					"CalculatorDroplet supports only two operands! operand delimiter is ',' ");
		}
		request.setParameter(RESULT, calculate(operator, tempOperands));
		request.serviceLocalParameter(OUTPUT, request, response);
	}

	private String calculate(final String operator, final String... operands) {
		final StringBuilder builder = new StringBuilder();
		builder.append(operands[0]);
		builder.append(SPACE);
		builder.append(operator);
		builder.append(SPACE);
		builder.append(operands[1]);
		builder.append(SPACE);
		builder.append(EQUALS);
		builder.append(SPACE);
		if (ADD.equalsIgnoreCase(operator)) {
			builder.append(Integer.valueOf(operands[0])
					+ Integer.valueOf(operands[1]));
		} else if (SUB.equals(operator)) {
			builder.append(Integer.valueOf(operands[0])
					- Integer.valueOf(operands[1]));
		} else if (MUL.equalsIgnoreCase(operator)) {
			builder.append(Integer.valueOf(operands[0])
					* Integer.valueOf(operands[1]));
		} else {
			throw new IllegalArgumentException(
					"CalculatorDroplet doesn't support the given operator ->"
							+ operator);
		}
		return builder.toString();
	}
}