package com.frugalbin.communication.caches;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.frugalbin.communication.models.CommunicationConnectionInfo;
import com.frugalbin.communication.services.impl.ServiceFactory;

public class CommunicationConnectionCache extends AbstractCache
{
	private static volatile CommunicationConnectionCache instance;

	private Map<Long, CommunicationConnectionInfo> connectionMap = new HashMap<Long, CommunicationConnectionInfo>();

	private CommunicationConnectionCache()
	{
	}

	public static CommunicationConnectionCache getInstance()
	{
		if (instance == null)
		{
			synchronized (CommunicationConnectionCache.class)
			{
				if (instance == null)
				{
					instance = new CommunicationConnectionCache();
				}
			}
		}

		return instance;
	}

	@Override
	public void initializeCache(ServiceFactory serviceFactory)
	{
		super.initializeCache(serviceFactory);
	}

	@Override
	public void refreshCache()
	{
		List<CommunicationConnectionInfo> connectionInfo = serviceFactory.getCommunicationConnectionInfoService()
				.getAllConnections();

		connectionMap = connectionInfo.stream().collect(
				Collectors.toMap(CommunicationConnectionInfo::getCommunicationConnectionId, (c) -> c));
	}

	public CommunicationConnectionInfo getCommunicationConnectionInfo(Long communicationConnectionId)
	{
		return connectionMap.get(communicationConnectionId);
	}
}
