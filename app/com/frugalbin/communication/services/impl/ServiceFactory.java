package com.frugalbin.communication.services.impl;

import javax.inject.Inject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.frugalbin.communication.models.email.EmailInfo;
import com.frugalbin.communication.models.sms.SmsInfo;
import com.frugalbin.communication.services.CommunicationInfoServiceI;
import com.frugalbin.communication.services.CommunicationsServiceI;
import com.frugalbin.communication.services.TemplateServiceI;

@Configuration
@ComponentScan({ "com.frugalbin.communication.models.sms", "com.frugalbin.communication.models.email" })
public class ServiceFactory
{
	@Inject
	private CommunicationsServiceI communicationService;

	@Inject
	private TemplateServiceI templateService;

	@Inject
	private CommunicationInfoServiceI<SmsInfo> smsInfoService;

	@Inject
	private CommunicationInfoServiceI<EmailInfo> emailInfoService;

	public CommunicationsServiceI getCommunicationService()
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
}
