package com.frugalbin.communication.caches;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.frugalbin.communication.exceptions.BusinessException;
import com.frugalbin.communication.models.CommunicationConnectionInfo;
import com.frugalbin.communication.models.helpers.CommunicationType;
import com.frugalbin.communication.sender.EmailSender;
import com.frugalbin.communication.sender.SMSSender;
import com.frugalbin.communication.services.impl.ServiceFactory;
import com.frugalbin.communication.utils.CommConnStatus;

public class CommunicationConnectionCache extends AbstractCache
{
	private static volatile CommunicationConnectionCache instance;
	
	private static Logger LOGGER = LoggerFactory.getLogger(CommunicationConnectionCache.class);

	private Map<Long, CommunicationConnectionInfo> connectionMap = new HashMap<Long, CommunicationConnectionInfo>();
	private CommunicationConnectionInfo emailCI;
	private CommunicationConnectionInfo smsCI;

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
		
		CommunicationConnectionInfo connInfo = new CommunicationConnectionInfo();
		connInfo.setHost("http://www.sms2.kapsystem.com/blank/sms/user/urlsms.php?username=<username>&pass=<password>&senderid=<senderId>&dest_mobileno=<destMobileNo>&message=<messageBody>&response=Y");
		connInfo.setCommunicationType(CommunicationType.SMS);
		connInfo.setUserName("upcurve");
		connInfo.setPassword("kap@user!789");
		connInfo.setStatus(CommConnStatus.ACTIVE);
		connInfo.setKeyValuePairs("params=<username>,<password>,<senderId>,<destMobileNo>,<messageBody>");
		serviceFactory.getCommunicationConnectionInfoService().insertCommConnectionInfo(connInfo);
		
		connInfo = new CommunicationConnectionInfo();
		connInfo.setHost("email-smtp.us-west-2.amazonaws.com");
		connInfo.setPort("25");
		connInfo.setCommunicationType(CommunicationType.EMAIL);
		connInfo.setUserName("AKIAIPXWNP7VW2YS2PQA");
		connInfo.setPassword("AuyhHrTiNpzXPXISJQRyAOR3kCrff7oIZ5DsYEuyfrwS");
		connInfo.setStatus(CommConnStatus.ACTIVE);
		serviceFactory.getCommunicationConnectionInfoService().insertCommConnectionInfo(connInfo);
	}

	@Override
	public void refreshCache()
	{
		List<CommunicationConnectionInfo> connectionInfoList = serviceFactory.getCommunicationConnectionInfoService()
				.getAllConnections();

		for (CommunicationConnectionInfo communicationConnectionInfo : connectionInfoList)
		{
			connectionMap.put(communicationConnectionInfo.getCommunicationConnectionId(), communicationConnectionInfo);
		}

		for (CommunicationConnectionInfo communicationInfo : connectionInfoList)
		{
			CommunicationType communicationType = communicationInfo.getCommunicationType();

			if (emailCI == null && CommunicationType.EMAIL.equals(communicationType)
					&& CommConnStatus.ACTIVE.equals(communicationInfo.getStatus()))
			{
				emailCI = communicationInfo;
				try
				{
					EmailSender.createInstance(emailCI);
				}
				catch (BusinessException e)
				{
					LOGGER.error("Got error while initiating email sender", e);
				}
			}

			if (smsCI == null && CommunicationType.SMS.equals(communicationType)
					&& CommConnStatus.ACTIVE.equals(communicationInfo.getStatus()))
			{
				smsCI = communicationInfo;
				try
				{
					SMSSender.createInstance(smsCI);
				}
				catch (BusinessException e)
				{
					LOGGER.error("Got error while initiating email sender", e);
				}
			}
		}
	}

	public CommunicationConnectionInfo getCommunicationConnectionInfo(Long communicationConnectionId)
	{
		return connectionMap.get(communicationConnectionId);
	}

	public CommunicationConnectionInfo getEmailCI()
	{
		return emailCI;
	}

	public CommunicationConnectionInfo getSmsCI()
	{
		return smsCI;
	}
}
