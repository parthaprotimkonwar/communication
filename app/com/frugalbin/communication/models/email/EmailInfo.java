package com.frugalbin.communication.models.email;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.frugalbin.communication.models.CommunicationInfo;
import com.frugalbin.communication.utils.Constants;

@Entity
@Table(name = Constants.EMAIL_INFO_TABLE, schema = Constants.COMMUNICATION_SCHEMA)
public class EmailInfo extends CommunicationInfo
{
	public Long getEmailInfoId()
	{
		return id;
	}

	public void setEmailInfoId(Long emailInfoId)
	{
		this.id = emailInfoId;
	}
}