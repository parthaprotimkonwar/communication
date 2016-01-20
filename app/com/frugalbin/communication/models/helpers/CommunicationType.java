package com.frugalbin.communication.models.helpers;

public enum CommunicationType
{
	EMAIL,
	SMS,
	EMAIL_SMS;

	public boolean isSMSType()
	{
		return this.equals(SMS) || this.equals(EMAIL_SMS);
	}

	public boolean isEmailType()
	{
		return this.equals(EMAIL) || this.equals(EMAIL_SMS);
	}
}
