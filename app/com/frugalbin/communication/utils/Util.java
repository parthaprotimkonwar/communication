package com.frugalbin.communication.utils;

import com.frugalbin.communication.models.Template;

public class Util
{
	public static String getMessageContent(Template template, String keyValues)
	{
		String messageContent = template.getTemplateContent();
		String[] keyList = template.getKeys().split(",");
		String[] keyValueList = keyValues.split(",");

		if (keyList.length != keyValueList.length)
		{
			// Throw Exception
		}

		for (int i = 0; i < keyValues.length(); i++)
		{
			messageContent.replace(keyList[i], keyValueList[i]);
		}

		return messageContent;
	}
}
