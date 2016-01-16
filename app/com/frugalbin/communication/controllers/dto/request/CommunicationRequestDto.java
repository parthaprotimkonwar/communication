package com.frugalbin.communication.controllers.dto.request;

import org.apache.commons.lang3.StringUtils;

public class CommunicationRequestDto
{
	private Long templateId = 1L;

	/*
	 * TODO: need to change to list/map instead of String
	 */
	private String keyValues = StringUtils.EMPTY;

	public Long getTemplateId()
	{
		return templateId;
	}

	public void setTemplateId(Long templateId)
	{
		this.templateId = templateId;
	}

	public String getKeyValues()
	{
		return keyValues;
	}

	public void setKeyValues(String keyValues)
	{
		this.keyValues = keyValues;
	}

}
