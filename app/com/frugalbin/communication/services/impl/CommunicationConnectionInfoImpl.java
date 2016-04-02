/**
 * 
 */
package com.frugalbin.communication.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.frugalbin.communication.models.CommunicationConnectionInfo;
import com.frugalbin.communication.repositories.CommunicationConnectionInfoRepository;
import com.frugalbin.communication.services.CommunicationConnectionInfoServiceI;

@Named
@Singleton
public class CommunicationConnectionInfoImpl implements CommunicationConnectionInfoServiceI
{
	@Inject
	private CommunicationConnectionInfoRepository repository;
	
	@Override
	public List<CommunicationConnectionInfo> getAllConnections()
	{
		return repository.findAll();
	}

	@Override
	public CommunicationConnectionInfo insertCommConnectionInfo(CommunicationConnectionInfo connInfo)
	{
		CommunicationConnectionInfo savedConnInfo = repository.saveAndFlush(connInfo);
		return savedConnInfo;
	}

}
