package com.frugalbin.communication.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.frugalbin.communication.models.helpers.CommunicationType;
import com.frugalbin.communication.utils.Constants;

@Entity
@Table(name = Constants.COMMUNICATION_CONNECTION_TABLE, schema = Constants.COMMUNICATION_SCHEMA)
public class CommunicationConnectionInfo
{
	/*
	 * TODO: Add any other common columns
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Constants.ID_COLUMN)
	private Long id;

	@Column(name = Constants.CONNECTION_URL_COLUMN)
	private String connectionUrl;

	@Column(name = Constants.USER_NAME_COLUMN)
	private String userName;

	@Column(name = Constants.PASSWORD_COLUMN)
	private String password;

	@Column(name = Constants.KEY_VALUE_PAIRS_COLUMN)
	private String keyValuePairs;

	@Column(name = Constants.COMMUNICATION_TYPE_COLUMN)
	@Enumerated(EnumType.STRING)
	private CommunicationType communicationType;

	public Long getCommunicationConnectionId()
	{
		return id;
	}

	public String getConnectionUrl()
	{
		return connectionUrl;
	}

	public String getUserName()
	{
		return userName;
	}

	public String getPassword()
	{
		return password;
	}

	public String getKeyValuePairs()
	{
		return keyValuePairs;
	}

	public CommunicationType getCommunicationType()
	{
		return communicationType;
	}
}
