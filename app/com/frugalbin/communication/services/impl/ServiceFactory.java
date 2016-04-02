package com.frugalbin.communication.services.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.frugalbin.communication.models.email.EmailInfo;
import com.frugalbin.communication.models.sms.SmsInfo;
import com.frugalbin.communication.services.CommunicationConnectionInfoServiceI;
import com.frugalbin.communication.services.CommunicationInfoServiceI;
import com.frugalbin.communication.services.CommunicationServiceI;
import com.frugalbin.communication.services.TemplateServiceI;

@Named
@Singleton
public class ServiceFactory
{
	@Inject
	private CommunicationServiceI communicationService;

	@Inject
	private TemplateServiceI templateService;

	@Inject
	private CommunicationInfoServiceI<SmsInfo> smsInfoService;

	@Inject
	private CommunicationInfoServiceI<EmailInfo> emailInfoService;

	@Inject
	private CommunicationConnectionInfoServiceI communicationConnectionInfoService;

	public CommunicationServiceI getCommunicationService()
	{
		return communicationService;
	}

	public TemplateServiceI getTemplateService()
	{
		return templateService;
	}

	public CommunicationInfoServiceI<SmsInfo> getSmsInfoService()
	{
		return smsInfoService;
	}

	public CommunicationInfoServiceI<EmailInfo> getEmailInfoService()
	{
		return emailInfoService;
	}

	public CommunicationConnectionInfoServiceI getCommunicationConnectionInfoService()
	{
		return communicationConnectionInfoService;
	}
}
