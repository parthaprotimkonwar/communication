package com.frugalbin.communication.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.frugalbin.communication.models.email.EmailInfo;
import com.frugalbin.communication.models.sms.SmsInfo;
import com.frugalbin.communication.utils.Constants;

@Entity
@Table(name = Constants.COMMUNICATION_TABLE, schema = Constants.COMMUNICATION_SCHEMA)
public class Communication
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Constants.ID_COLUMN)
	private Long communicationId;

	@OneToOne(fetch = FetchType.EAGER)
	private SmsInfo smsInfo;

	@OneToOne(fetch = FetchType.EAGER)
	private EmailInfo emailInfo;

	public Long getCommunicationId()
	{
		return communicationId;
	}

	public void setCommunicationId(Long communicationId)
	{
		this.communicationId = communicationId;
	}

	public SmsInfo getSmsInfo()
	{
		return smsInfo;
	}

	public void setSmsInfo(SmsInfo smsInfo)
	{
		this.smsInfo = smsInfo;
	}

	public EmailInfo getEmailInfo()
	{
		return emailInfo;
	}

	public void setEmailInfo(EmailInfo emailInfo)
	{
		this.emailInfo = emailInfo;
	}
}
