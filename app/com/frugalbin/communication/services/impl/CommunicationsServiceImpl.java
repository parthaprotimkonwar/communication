package com.frugalbin.communication.services.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.frugalbin.communication.exceptions.BusinessException;
import com.frugalbin.communication.models.Communication;
import com.frugalbin.communication.models.email.EmailInfo;
import com.frugalbin.communication.models.sms.SmsInfo;
import com.frugalbin.communication.repositories.CommunicationRepository;
import com.frugalbin.communication.services.CommunicationsServiceI;

@Named
@Singleton
public class CommunicationsServiceImpl implements CommunicationsServiceI
{
	@Inject
	private CommunicationRepository communicationRepository;

	@Override
	public Communication insertCommunication(SmsInfo smsInfo, EmailInfo emailInfo) throws BusinessException
	{
		Communication communication = new Communication();
		communication.setSmsInfo(smsInfo);
		communication.setEmailInfo(emailInfo);

		communicationRepository.saveAndFlush(communication);
		return communication;
	}
}
