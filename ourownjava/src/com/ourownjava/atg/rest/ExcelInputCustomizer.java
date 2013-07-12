package com.ourownjava.atg.rest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import atg.rest.RestException;
import atg.rest.input.RestInputCustomizerImpl;
import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;

/**
 * @author ourownjava.com
 */

public class ExcelInputCustomizer extends RestInputCustomizerImpl {

	public ExcelInputCustomizer() {
		setFormat("vnd.ms-excel");
		setAcceptableMimeTypes(new String[] { "application/vnd.ms-excel" });
	}

	@Override
	public Class<?> getContainerClass() {
		return HSSFWorkbook.class;
	}

	@Override
	public Object parseString(final String paramString,
			final DynamoHttpServletRequest paramDynamoHttpServletRequest,
			final DynamoHttpServletResponse paramDynamoHttpServletResponse)
			throws RestException {
		try {
			return new HSSFWorkbook(new ByteArrayInputStream(
					paramString.getBytes("ISO-8859-1")));
		} catch (final UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("something went wrong, check log!");
	}

	@Override
	public Map<String, Object> convertToMap(final Object paramObject,
			final DynamoHttpServletRequest paramDynamoHttpServletRequest,
			final DynamoHttpServletResponse paramDynamoHttpServletResponse)
			throws RestException {

		final Map<String, Object> paramMap = new HashMap<String, Object>(2);
		paramMap.put("EXCEL_INPUT", paramObject);
		return paramMap;
	}

	@Override
	public Object instantiateObjectParameter(final Object paramObject,
			final DynamoHttpServletRequest paramDynamoHttpServletRequest,
			final DynamoHttpServletResponse paramDynamoHttpServletResponse)
			throws RestException {

		return paramObject;
	}

	@Override
	public boolean isValidTypeString(final String paramString) {
		return true;
	}

	@Override
	public String[] splitMultipleStringsAtCharacter(final String paramString,
			final char paramChar) {
		return new String[] { paramString };
	}

}