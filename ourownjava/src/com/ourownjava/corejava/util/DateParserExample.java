package com.ourownjava.corejava.util;

import junit.framework.Assert;
import org.junit.Test;
import com.thoughtworks.xstream.converters.basic.DateConverter;

/**
 *
 * @author ourownjava.com
 * 
 */

public class DateParserExample {

	private DateConverter converter = new DateConverter("dd-MMM-yyyy",
			new String [] {"dd-MMM-yyyy", "dd-MMM-yy", "yyyy-MMM-dd",
			"yyyy-MM-dd", "yyyy-dd-MM", "yyyy/MM/dd", "yyyy.MM.dd",
                         "MM-dd-yy", "dd-MM-yyyy"});

	private Object parse(String dateString){
		Object o = converter.fromString(dateString);
		System.out.println(converter.toString(o));
		return o;
	}

	@Test
	public void testddMMMyyyy(){
		Assert.assertTrue(parse("12-May-2011") instanceof java.util.Date);
	}

	@Test
	public void testddMMyy(){
		Assert.assertTrue(parse("12-May-11") instanceof java.util.Date);
	}

	@Test
	public void testyyyyMMMdd(){
		Assert.assertTrue(parse("2011-May-09") instanceof java.util.Date);
	}

	@Test
	public void testyyyyMMdd(){
		Assert.assertTrue(parse("2011-01-09") instanceof java.util.Date);
	}

	@Test
	public void testyyyyddMM(){
		Assert.assertTrue(parse("2011-30-09") instanceof java.util.Date);
	}

	@Test
	public void testyyyyMMdd2(){
		Assert.assertTrue(parse("2011/09/30") instanceof java.util.Date);
	}

	@Test
	public void testyyyyMMdd3(){
		Assert.assertTrue(parse("2011.09.30") instanceof java.util.Date);
	}

	@Test
	public void testMMddyyyy(){
		Assert.assertTrue(parse("09-30-2011") instanceof java.util.Date);
	}

	@Test
	public void testddMMyyyy(){
		Assert.assertTrue(parse("31-12-2011") instanceof java.util.Date);
	}
}
