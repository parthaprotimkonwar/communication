package com.frugalbin.communication.integration;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.frugalbin.communication.caches.TemplateCache;
import com.frugalbin.communication.controllers.dto.request.CommunicationRequestDto;
import com.frugalbin.communication.controllers.dto.request.SendCommunicationRequestDto;
import com.frugalbin.communication.exceptions.BusinessException;
import com.frugalbin.communication.models.Communication;
import com.frugalbin.communication.models.Template;
import com.frugalbin.communication.models.email.EmailInfo;
import com.frugalbin.communication.models.helpers.CommunicationStatus;
import com.frugalbin.communication.models.sms.SmsInfo;
import com.frugalbin.communication.sender.EmailSender;
import com.frugalbin.communication.sender.SMSSender;
import com.frugalbin.communication.services.impl.ServiceFactory;
import com.frugalbin.communication.utils.Constants;
import com.frugalbin.communication.utils.Util;

@Named
@Singleton
public class CommunicationInterface
{
	@Inject
	private ServiceFactory serviceFactory;

	public Communication createCommunication(CommunicationRequestDto commRequest) throws BusinessException
	{
		Template template = TemplateCache.getInstance().getTemplate(commRequest.getTemplateId());

		if (template == null)
		{
			throw new BusinessException(Constants.TEMPLATE_NOT_FOUND_ERROR_CODE,
					Constants.TEMPLATE_NOT_FOUND_ERROR_MESSAGE);
		}

		SmsInfo smsInfo = createSmsInfo(commRequest, template);

		EmailInfo emailInfo = createEmailInfo(commRequest, template);

		return serviceFactory.getCommunicationService().insertCommunication(smsInfo, emailInfo);
	}

	private EmailInfo createEmailInfo(CommunicationRequestDto commRequest, Template template)
	{
		if (!template.getTemplateType().isEmailType())
		{
			return null;
		}

		/*
		 * TODO: Complete the implementation with handling 
		 */
		EmailInfo emailInfo = new EmailInfo();
		emailInfo.setTemplate(template);
		emailInfo.setKeyValues(commRequest.getTemplateKeyValues());
		emailInfo.setFrom(commRequest.getFrom());
		emailInfo.setTo(commRequest.getTo());

		Map<String, String> commInfoKeyValues = Util.getKeyValueMap(commRequest.getCommInfoKeyValues());
		emailInfo.setVisibleName(commInfoKeyValues.get("VisibleName"));
		emailInfo.setSubject(commInfoKeyValues.get("Subject"));
		emailInfo.setStatus(CommunicationStatus.CREATED);

		return serviceFactory.getEmailInfoService().insertInfo(emailInfo);
	}

	private SmsInfo createSmsInfo(CommunicationRequestDto commRequest, Template template)
	{
		if (!template.getTemplateType().isSMSType())
		{
			return null;
		}

		/*
		 * TODO: Complete the implementation with handling 
		 */
		SmsInfo smsInfo = new SmsInfo();
		smsInfo.setTemplate(template);
		smsInfo.setKeyValues(commRequest.getTemplateKeyValues());

		return serviceFactory.getSmsInfoService().insertInfo(smsInfo);
	}

	public void sendCommunication(SendCommunicationRequestDto request)
			throws com.frugalbin.common.exceptions.BusinessException, BusinessException
	{
		for (Long communicationId : request.getCommunicationIds())
		{
			Communication communication = serviceFactory.getCommunicationService().getCommunication(communicationId);

			if (communication.getEmailInfo() != null)
			{
				EmailSender.getInstance()
						.sendEmail(communication.getEmailInfo().getTo(), communication.getEmailInfo().getFrom(),
								communication.getEmailInfo().getVisibleName(),
								communication.getEmailInfo().getSubject(),
								Util.getMessageContent(communication.getEmailInfo()));
			}

			if (communication.getSmsInfo() != null)
			{
				SMSSender.getInstance().sendSms(communication.getSmsInfo().getTo(),
						Util.getMessageContent(communication.getSmsInfo()));
			}
		}
	}
}
