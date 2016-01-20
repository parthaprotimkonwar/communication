package com.frugalbin.communication.controllers.dto.request;

public class SendCommunicationRequestDto
{
	private Long[] communicationIds;

	private Long[] communicationConnectionIds = { 1L, 2L };

	public Long[] getCommunicationIds()
	{
		return communicationIds;
	}

	public void setCommunicationIds(Long[] communicationIds)
	{
		this.communicationIds = communicationIds;
	}

	public Long[] getCommunicationConnectionIds()
	{
		return communicationConnectionIds;
	}

	public void setCommunicationConnectionIds(Long[] communicationConnectionIds)
	{
		this.communicationConnectionIds = communicationConnectionIds;
	}
}
