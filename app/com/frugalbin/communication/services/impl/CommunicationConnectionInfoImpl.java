/**
 * 
 */
package com.frugalbin.communication.services.impl;

import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import com.frugalbin.communication.models.CommunicationConnectionInfo;
import com.frugalbin.communication.services.CommunicationConnectionInfoI;

@Named
@Singleton
public class CommunicationConnectionInfoImpl implements CommunicationConnectionInfoI
{
	@Override
	public List<CommunicationConnectionInfo> getAllConnections()
	{
		return null;
	}

}
