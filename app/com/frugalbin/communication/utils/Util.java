package com.frugalbin.communication.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.frugalbin.communication.models.CommunicationInfo;
import com.frugalbin.communication.models.Template;

public class Util
{
	public static String getMessageContent(CommunicationInfo commInfo)
	{
		String templateMsg = commInfo.getTemplate().getTemplateContent();
		Map<String, String> keyValueMap = getKeyValueMap(commInfo.getKeyValues());

		String msg = null;
		for (Entry<String, String> keyValueEntry : keyValueMap.entrySet())
		{
			msg = templateMsg.replace(keyValueEntry.getKey(), keyValueEntry.getValue());
		}

		return msg;

	}

	public static Map<String, String> getKeyValueMap(String keyValues)
	{
		Map<String, String> map = new HashMap<String, String>();
		
		for (String keyValuePair : keyValues.split(Constants.KEY_VALUE_PAIR_SEPARATOR))
		{
			String[] keyValue = keyValuePair.split(Constants.KEY_VALUE_SEPARATOR);
			map.put(keyValue[0], keyValue[1]);
		}
		return map;
	}
}
