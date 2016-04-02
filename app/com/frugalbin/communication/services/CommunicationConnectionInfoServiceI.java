package com.frugalbin.communication.services;

import java.util.List;

import com.frugalbin.communication.models.CommunicationConnectionInfo;

public interface CommunicationConnectionInfoServiceI
{
	List<CommunicationConnectionInfo> getAllConnections();

	CommunicationConnectionInfo insertCommConnectionInfo(CommunicationConnectionInfo connInfo);
}
