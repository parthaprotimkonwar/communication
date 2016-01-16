package com.frugalbin.communication.models.email;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.frugalbin.communication.models.CommunicationInfo;
import com.frugalbin.communication.models.Template;
import com.frugalbin.communication.models.helpers.CommunicationStatus;
import com.frugalbin.communication.utils.Constants;

@Entity
@Table(name = Constants.EMAIL_INFO_TABLE, schema = Constants.COMMUNICATION_SCHEMA)
public class EmailInfo extends CommunicationInfo
{
	@Column(name = Constants.STATUS_COLUMN)
	@Enumerated(EnumType.STRING)
	private CommunicationStatus status;

	@Column(name = Constants.RETRY_COUNT_COLUMN)
	private int retryCount;

	@Column(name = Constants.SEND_TIME_COLUMN)
	private Date sentTime;

	/*
	 * TODO: need to convert string to list 
	 * Currently it is comma separated
	 */
	@Column(name = Constants.KEY_VALUES_COLUMN)
	private String keyValues;

	@ManyToOne
	private Template template;

	public Long getEmailInfoId()
	{
		return id;
	}

	public void setEmailInfoId(Long emailInfoId)
	{
		this.id = emailInfoId;
	}

	public CommunicationStatus getStatus()
	{
		return status;
	}

	public void setStatus(CommunicationStatus status)
	{
		this.status = status;
	}

	public int getRetryCount()
	{
		return retryCount;
	}

	public void setRetryCount(int retryCount)
	{
		this.retryCount = retryCount;
	}

	public Date getSentTime()
	{
		return sentTime;
	}

	public void setSentTime(Date sentTime)
	{
		this.sentTime = sentTime;
	}

	public String getKeyValues()
	{
		return keyValues;
	}

	public void setKeyValues(String keyValues)
	{
		this.keyValues = keyValues;
	}

	public Template getTemplate()
	{
		return template;
	}

	public void setTemplate(Template template)
	{
		this.template = template;
	}
}