package com.frugalbin.communication.utils;

public interface Constants
{
	// Schema
	static final String COMMUNICATION_SCHEMA = "COMMUNICATION";

	// Table Names
	static final String SMS_INFO_TABLE = "SMS_INFO";
	static final String EMAIL_INFO_TABLE = "EMAIL_INFO";
	static final String TEMPLATE_TABLE = "TEMPLATE";
	static final String COMMUNICATION_TABLE = "COMMUNICATION";
	static final String COMMUNICATION_CONNECTION_TABLE = "COMMUNICATION_CONNECTION";

	// Table Columns
	// Columns: Common
	static final String ID_COLUMN = "ID";
	static final String STATUS_COLUMN = "STATUS";

	// Columns: SMS_INFO and EMAIL_INFO table
	static final String RETRY_COUNT_COLUMN = "RETRY_COUNT";
	static final String SEND_TIME_COLUMN = "SEND_TIME";
	static final String TEMPLATE_ID_COLUMN = "TEMPLATE_ID";
	static final String KEY_VALUES_COLUMN = "KEY_VALUES";
	static final String TO_COLUMN = "TO_VALUE";
	static final String FROM_COLUMN = "FROM_VALUE";
	static final String SUBJECT_COLUMN = "SUBJECT";

	// Columns: Template table
	static final String TEMPLATE_CONTENT_COLUMN = "TEMPLATE_CONTENT";
	static final String TEMPLATE_NAME_COLUMN = "TEMPLATE_NAME";
	static final String TEMPLATE_TYPE_COLUMN = "TYPE";
	static final String KEYS_COLUMN = "KEYS";

	// Columns: Communication Table
	static final String SMS_INFO_ID_COLUMN = "SMS_INFO_ID";
	static final String EMAIL_INFO_ID_COLUMN = "EMAIL_INFO_ID";

	// Columns: CommunicationConnectionInfo Table
	static final String HOST_COLUMN = "HOST";
	static final String PORT_COLUMN = "PORT";
	static final String USER_NAME_COLUMN = "USER_NAME";
	static final String PASSWORD_COLUMN = "PASSWORD";
	static final String KEY_VALUE_PAIRS_COLUMN = "KEY_VALUE_PAIRS";
	static final String COMMUNICATION_TYPE_COLUMN = "COMMUNICATION_TYPE";
	static final String VISBLE_NAME_COLUMN = "VISIBLE_NAME";

	// ERROR Codes
	static final int TEMPLATE_NOT_FOUND_ERROR_CODE = 1001;

	// ERROR Messages
	static final String TEMPLATE_NOT_FOUND_ERROR_MESSAGE = "Template with Id {} not found";

	public static final String SMS_PARAMS_ARG = "params";

	public static final String KEY_VALUE_PAIR_SEPARATOR = ";";

	public static final String KEY_VALUE_SEPARATOR = "=";

	public static final String PARAM_SEPARATOR = ",";

}
