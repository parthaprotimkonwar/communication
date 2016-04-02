package com.frugalbin.communication.models.sms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.frugalbin.communication.models.CommunicationInfo;
import com.frugalbin.communication.utils.Constants;

@Entity
@Table(name = Constants.SMS_INFO_TABLE, schema = Constants.COMMUNICATION_SCHEMA)
public class SmsInfo extends CommunicationInfo
{
	public Long getSmsInfoId()
	{
		return id;
	}

	public void setSmsInfoId(Long smsInfoId)
	{
		this.id = smsInfoId;
	}
}