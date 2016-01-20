package com.frugalbin.communication.controllers.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.mvc.BodyParser;
import play.mvc.Result;

import com.frugalbin.communication.caches.CacheManager;
import com.frugalbin.communication.controllers.base.BaseController;
import com.frugalbin.communication.controllers.dto.request.CommunicationRequestDto;
import com.frugalbin.communication.controllers.dto.request.SendCommunicationRequestDto;
import com.frugalbin.communication.exceptions.BusinessException;
import com.frugalbin.communication.integration.CommunicationInterface;
import com.frugalbin.communication.models.Communication;

@Named
@Singleton
public class CommunicationController extends BaseController
{
	private static final Logger LOGGER = LoggerFactory.getLogger(CommunicationController.class);

	@Inject
	private CommunicationInterface communicationInterface;

	@Inject
	private CacheManager cacheManager;

	@BodyParser.Of(BodyParser.Json.class)
	public Result getCommunicationDetails(Long id)
	{
		/*
		 * TODO: Complete getter method
		 */
		return convertObjectToJsonResponse("Communication Details: " + id);
	}

	@BodyParser.Of(BodyParser.Json.class)
	public Result sendCommunication(Long id)
	{
		try
		{
			SendCommunicationRequestDto request = convertRequestBodyToObject(request().body(),
					SendCommunicationRequestDto.class);
			communicationInterface.sendCommunication(request);
		}
		catch (BusinessException e)
		{
			LOGGER.error("Could not create Communication", e);
			return convertObjectToJsonResponse("Comm creation error: " + e.getErrorMessage());
		}

		return convertObjectToJsonResponse("Communication Sent: " + id);
	}

	@BodyParser.Of(BodyParser.Json.class)
	public Result createCommunication()
	{
		Communication communication;
		try
		{
			CommunicationRequestDto request = convertRequestBodyToObject(request().body(),
					CommunicationRequestDto.class);
			communication = communicationInterface.createCommunication(request);
		}
		catch (BusinessException e)
		{
			LOGGER.error("Could not create Communication", e);
			return convertObjectToJsonResponse("Comm creation error: " + e.getErrorMessage());
		}

		return convertObjectToJsonResponse(communication.getCommunicationId());
	}

	@BodyParser.Of(BodyParser.Json.class)
	public Result refreshDB()
	{
		/*
		 * TODO: handle any exceptions 
		 */
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
