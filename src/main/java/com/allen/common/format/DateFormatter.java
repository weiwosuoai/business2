package com.allen.common.format;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日期格式转换器
 * @author Allen
 *
 */
public class DateFormatter implements Formatter<Date> {
	
	private String datePattern;
	private SimpleDateFormat dateFormat;

	public DateFormatter(String datePattern) {
		this.datePattern = datePattern;
		dateFormat = new SimpleDateFormat(datePattern);
		dateFormat.setLenient(false); // 严格限制日期格式
	}

	public String print(Date date, Locale locale) {
		return dateFormat.format(date);
	}

	public Date parse(String strDate, Locale locale) throws ParseException {
		try {
			return dateFormat.parse(strDate);
		} catch (Exception e) {
			// the error message will be displayed when using <form:errors>
			throw new IllegalArgumentException(
					"invalid date format. Please use this pattern - " + datePattern + " -");
		}
	}

}
