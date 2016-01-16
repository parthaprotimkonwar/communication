package com.frugalbin.communication.controllers.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.mvc.BodyParser;
import play.mvc.Result;

import com.frugalbin.communication.caches.CacheManager;
import com.frugalbin.communication.caches.TemplateCache;
import com.frugalbin.communication.controllers.base.BaseController;
import com.frugalbin.communication.controllers.dto.request.CommunicationRequestDto;
import com.frugalbin.communication.exceptions.BusinessException;
import com.frugalbin.communication.models.Communication;
import com.frugalbin.communication.models.Template;
import com.frugalbin.communication.models.email.EmailInfo;
import com.frugalbin.communication.models.sms.SmsInfo;
import com.frugalbin.communication.services.impl.ServiceFactory;
import com.frugalbin.communication.utils.Constants;

@Named
@Singleton
public class CommunicationController extends BaseController
{
	private static final Logger LOGGER = LoggerFactory.getLogger(CommunicationController.class);

	@Inject
	private ServiceFactory serviceFactory;

	@Inject
	private CacheManager cacheManager;

	@BodyParser.Of(BodyParser.Json.class)
	public Result getCommunicationDetails(Long id)
	{
		return convertObjectToJsonResponse("Communication Details: " + id);
	}

	/**
	 * TODO : validate if the user/token is valid
	 * 
	 * @return
	 */
	@BodyParser.Of(BodyParser.Json.class)
	public Result sendCommunication(Long id)
	{
		return convertObjectToJsonResponse("Communication Sent: " + id);
	}

	@BodyParser.Of(BodyParser.Json.class)
	public Result createCommunication()
	{
		CommunicationRequestDto request;
		Communication communication;
		try
		{
			request = convertRequestBodyToObject(request().body(), CommunicationRequestDto.class);
			communication = createCommunication(request);
		}
		catch (BusinessException e)
		{
			return convertObjectToJsonResponse("Comm creation error: " + e.getErrorMessage());
		}
		return convertObjectToJsonResponse(communication);
	}

	private Communication createCommunication(CommunicationRequestDto commRequest) throws BusinessException
	{
		Template template = TemplateCache.getInstance().getTemplate(commRequest.getTemplateId());

		if (template == null)
		{
			throw new BusinessException(Constants.TEMPLATE_NOT_FOUND_ERROR_CODE,
					Constants.TEMPLATE_NOT_FOUND_ERROR_MESSAGE);
		}

		/*
		 * TODO: move creation of smsInfo and emailInfo to separate method or class and Complete the implementation with handling 
		 */
		SmsInfo smsInfo = null;
		if (template.getTemplateType().isSMSType())
		{
			smsInfo = new SmsInfo();
			smsInfo.setTemplate(template);

			smsInfo = serviceFactory.getSmsInfoService().insertInfo(smsInfo);
		}

		EmailInfo emailInfo = null;
		if (template.getTemplateType().isEmailType())
		{
			emailInfo = new EmailInfo();
			emailInfo.setTemplate(template);

			emailInfo = serviceFactory.getEmailInfoService().insertInfo(emailInfo);
		}

		return serviceFactory.getCommunicationService().insertCommunication(smsInfo, emailInfo);
	}

	@BodyParser.Of(BodyParser.Json.class)
	public Result refreshDB()
	{
		LOGGER.info("Refresh Cache Service has been called");
		cacheManager.refreshCaches();
		return convertObjectToJsonResponse(Boolean.TRUE);
	}

	@BodyParser.Of(BodyParser.Json.class)
	public Result getTemplate(String templateName)
	{
		return convertObjectToJsonResponse("template is there");
	}
}
