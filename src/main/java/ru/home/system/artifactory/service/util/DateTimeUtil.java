package ru.home.system.artifactory.service.util;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
public class DateTimeUtil
{
	public static final String YYYY_MM_DD_T_HH_MM = "yyyy-MM-dd'T'HH:mm";

	private DateTimeUtil()
	{
	}

	public static String dateTimeToString(LocalDateTime localDateTime, String pattern)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return localDateTime.format(formatter);
	}

	public static LocalDateTime stringToDateTime(String str, String pattern)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return LocalDateTime.parse(str, formatter);
	}

	public static Date strToDate(String date, String pattern)
	{
		DateFormat format = new SimpleDateFormat(pattern);
		Date result = null;
		try
		{
			result = format.parse(date);
		}
		catch (ParseException e)
		{
			log.error(e.getMessage(), e);
		}

		return result;
	}
}
