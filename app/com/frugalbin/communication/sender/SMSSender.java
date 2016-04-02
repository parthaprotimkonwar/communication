package com.frugalbin.communication.sender;

import com.frugalbin.common.rest.client.RequestType;
import com.frugalbin.common.rest.client.RestClient;
import com.frugalbin.common.rest.client.RestClientProtocolInterface;
import com.frugalbin.communication.exceptions.BusinessException;
import com.frugalbin.communication.models.CommunicationConnectionInfo;
import com.frugalbin.communication.utils.Constants;

public class SMSSender implements RestClientProtocolInterface
{
	private static volatile SMSSender instance;
	private final String url;

	private final RequestType reqType;

	private final String[] params;

	private final String userName;

	private final String password;
	
	private final String senderId;
	
	public static SMSSender getInstance() throws BusinessException
	{
		if (instance == null)
		{
			synchronized (SMSSender.class)
			{
				if (instance == null)
				{
					throw new BusinessException(1001, "Instance for SMS Sender hasn't been created yet");
				}
			}
		}

		return instance;
	}

	public static void createInstance(CommunicationConnectionInfo commConnInfo) throws BusinessException
	{
		if (instance == null)
		{
			synchronized (SMSSender.class)
			{
				if (instance == null)
				{
					instance = new SMSSender(commConnInfo);
				}
			}
		}

		throw new BusinessException(1001, "Instance has been already created");
	}


/*
 * http://www.sms2.kapsystem.com/blank/sms/user/urlsms.php?username=XXXX&pass=XXXX&senderid=XXXX&dest_mobileno=XXX
 * X&message=XXXX&response=Y
 */
	private SMSSender(CommunicationConnectionInfo commConnInfo)
	{
		url = commConnInfo.getConnectionUrl();
		userName = commConnInfo.getUserName();
		password = commConnInfo.getPassword();
		reqType = RequestType.GET;
		String keyValPairs = commConnInfo.getKeyValuePairs();
		String[] pairs = keyValPairs.split(";");
		
		String pair = "";
		for (String string : pairs)
		{
			if(string.startsWith(Constants.SMS_PARAMS_ARG + Constants.KEY_VALUE_SEPARATOR))
			{
				pair = string;
				break;
			}
		}
		
		params = pair.replace(Constants.SMS_PARAMS_ARG + Constants.KEY_VALUE_SEPARATOR, "").split(Constants.PARAM_SEPARATOR);
		
		senderId = "FrugalBin";
	}

	public void sendSms(String to, String messageBody) throws com.frugalbin.common.exceptions.BusinessException
	{
		String[] valParams = new String[5];
		valParams[0] = userName;
		valParams[1] = password;
		valParams[2] = senderId;
		valParams[3] = to;
		valParams[4] = messageBody;
		RestClient.sendRequest(this, valParams);
	}

	@Override
	public String getName()
	{
		return "SmsSender";
	}

	@Override
	public String[] getParams()
	{
		return params;
	}

	@Override
	public RequestType getReqType()
	{
		return reqType;
	}

	@Override
	public String getUrl()
	{
		return url;
	}
}
