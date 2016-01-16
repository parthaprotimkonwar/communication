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

	// Table Columns
	// Columns: Common
	static final String ID_COLUMN = "ID";

	// Columns: SMS_INFO and EMAIL_INFO table
	static final String STATUS_COLUMN = "STATUS";
	static final String RETRY_COUNT_COLUMN = "RETRY_COUNT";
	static final String SEND_TIME_COLUMN = "SEND_TIME";
	static final String TEMPLATE_ID_COLUMN = "TEMPLATE_ID";
	static final String KEY_VALUES_COLUMN = "KEY_VALUES";

	// Columns: Template table
	static final String TEMPLATE_CONTENT_COLUMN = "TEMPLATE_CONTENT";
	static final String TEMPLATE_NAME_COLUMN = "TEMPLATE_NAME";
	static final String TEMPLATE_TYPE_COLUMN = "TYPE";
	static final String KEYS_COLUMN = "KEYS";

	// Columns: Communication Table
	static final String SMS_INFO_ID_COLUMN = "SMS_INFO_ID";
	static final String EMAIL_INFO_ID_COLUMN = "EMAIL_INFO_ID";

	// ERROR Codes
	static final int TEMPLATE_NOT_FOUND_ERROR_CODE = 1001;

	// ERROR Messages
	static final String TEMPLATE_NOT_FOUND_ERROR_MESSAGE = "Template with Id {} not found";

}
