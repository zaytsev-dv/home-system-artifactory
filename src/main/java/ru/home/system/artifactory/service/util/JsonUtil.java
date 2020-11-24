package ru.home.system.artifactory.service.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Slf4j
public class JsonUtil
{
	private JsonUtil()
	{
	}

	public static String toJson(Object clazz)
	{
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		final ObjectMapper mapper = new ObjectMapper();
		try
		{
			mapper.writeValue(out, clazz);
			final byte[] data = out.toByteArray();
			return new String(data);
		}
		catch (IOException e)
		{
			log.error(e.getMessage());
		}

		return null;
	}
}
