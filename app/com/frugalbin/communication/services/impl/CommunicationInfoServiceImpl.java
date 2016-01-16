package com.frugalbin.communication.services.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.frugalbin.communication.models.CommunicationInfo;
import com.frugalbin.communication.repositories.CommunicationInfoRepository;
import com.frugalbin.communication.services.CommunicationInfoServiceI;

@Named
public class CommunicationInfoServiceImpl<Info extends CommunicationInfo> implements CommunicationInfoServiceI<Info>
{
	@Inject
	private CommunicationInfoRepository<Info> infoRepository;

	@Override
	public Info insertInfo(Info info)
	{
		return infoRepository.saveAndFlush(info);
	}
}
