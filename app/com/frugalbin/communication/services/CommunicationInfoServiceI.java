package com.frugalbin.communication.services;

import com.frugalbin.communication.models.CommunicationInfo;

public interface CommunicationInfoServiceI<Info extends CommunicationInfo>
{
	Info insertInfo(Info info);
}
