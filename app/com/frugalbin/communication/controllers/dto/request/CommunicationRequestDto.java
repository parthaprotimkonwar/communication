package com.frugalbin.communication.controllers.dto.request;

import org.apache.commons.lang3.StringUtils;

public class CommunicationRequestDto
{
	private Long templateId = 1L;

	/*
	 * TODO: need to change to list/map instead of String
	 */
	private String templateKeyValues = StringUtils.EMPTY;

	private String from = "care@frugalbin.com";

	private String to;

	private String commInfoKeyValues = StringUtils.EMPTY;

	public Long getTemplateId()
	{
		return templateId;
	}

	public void setTemplateId(Long templateId)
	{
		this.templateId = templateId;
	}

	public String getTemplateKeyValues()
	{
		return templateKeyValues;
	}

	public void setTemplateKeyValues(String templateKeyValues)
	{
		this.templateKeyValues = templateKeyValues;
	}

	public String getFrom()
	{
		return from;
	}

	public void setFrom(String from)
	{
		this.from = from;
	}

	public String getTo()
	{
		return to;
	}

	public void setTo(String to)
	{
		this.to = to;
	}

	public String getCommInfoKeyValues()
	{
		return commInfoKeyValues;
	}

	public void setCommInfoKeyValues(String commInfoKeyValues)
	{
		this.commInfoKeyValues = commInfoKeyValues;
	}
}
