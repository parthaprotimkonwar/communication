package com.frugalbin.communication.services;

import java.util.List;

import com.frugalbin.communication.models.CommunicationConnectionInfo;

public interface CommunicationConnectionInfoI
{
	List<CommunicationConnectionInfo> getAllConnections();
}
