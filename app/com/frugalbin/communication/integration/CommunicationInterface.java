package com.frugalbin.communication.integration;

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
import com.frugalbin.communication.models.sms.SmsInfo;
import com.frugalbin.communication.services.impl.ServiceFactory;
import com.frugalbin.communication.utils.Constants;

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
		if (!template.getTemplateType().isSMSType())
		{
			return null;
		}

		/*
		 * TODO: Complete the implementation with handling 
		 */
		EmailInfo emailInfo = new EmailInfo();
		emailInfo.setTemplate(template);
		emailInfo.setKeyValues(commRequest.getKeyValues());

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
		smsInfo.setKeyValues(commRequest.getKeyValues());

		return serviceFactory.getSmsInfoService().insertInfo(smsInfo);
	}

	public void sendCommunication(SendCommunicationRequestDto request)
	{
		for (Long communicationId : request.getCommunicationIds())
		{
			Communication communication = serviceFactory.getCommunicationService().getCommunication(communicationId);
			/*
			 * TODO: implement reamaining
			 */
		}
	}
}
