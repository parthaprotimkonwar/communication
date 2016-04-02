package com.frugalbin.communication.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.frugalbin.communication.models.helpers.CommunicationStatus;
import com.frugalbin.communication.utils.Constants;

@MappedSuperclass
public class CommunicationInfo
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Constants.ID_COLUMN)
	protected Long id;

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
	
	@Column(name = Constants.TO_COLUMN)
	private String to;
	
	@Column(name = Constants.FROM_COLUMN)
	private String from;

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

	public String getTo()
	{
		return to;
	}

	public void setTo(String to)
	{
		this.to = to;
	}

	public String getFrom()
	{
		return from;
	}

	public void setFrom(String from)
	{
		this.from = from;
	}
}
