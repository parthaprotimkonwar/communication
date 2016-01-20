package com.frugalbin.communication.services;

import com.frugalbin.communication.exceptions.BusinessException;
import com.frugalbin.communication.models.Communication;
import com.frugalbin.communication.models.email.EmailInfo;
import com.frugalbin.communication.models.sms.SmsInfo;

public interface CommunicationServiceI
{
	// Communication createCommunication(Communication communication);
	Communication insertCommunication(SmsInfo smsInfo, EmailInfo emailInfo) throws BusinessException;

	Communication getCommunication(Long communicationId);
}
