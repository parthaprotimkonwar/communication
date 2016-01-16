package com.frugalbin.communication.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.frugalbin.communication.models.helpers.TemplateType;
import com.frugalbin.communication.utils.Constants;

@Entity
@Table(name = Constants.TEMPLATE_TABLE, schema = Constants.COMMUNICATION_SCHEMA)
public class Template
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Constants.ID_COLUMN)
	private Long templateId;

	@Column(name = Constants.TEMPLATE_CONTENT_COLUMN)
	private String templateContent;

	@Column(name = Constants.TEMPLATE_NAME_COLUMN)
	private String templateName;

	@Column(name = Constants.TEMPLATE_TYPE_COLUMN)
	@Enumerated(EnumType.STRING)
	private TemplateType templateType;

	/*
	 * TODO: need to convert string to list 											
	 * Currently it is comma separated
	 */
	@Column(name = Constants.KEYS_COLUMN)
	private String keys;

	public Long getTemplateId()
	{
		return templateId;
	}

	public String getTemplateContent()
	{
		return templateContent;
	}

	public String getTemplateName()
	{
		return templateName;
	}

	public TemplateType getTemplateType()
	{
		return templateType;
	}

	public String getKeys()
	{
		return keys;
	}

	public void setTemplateId(Long templateId)
	{
		this.templateId = templateId;
	}

	public void setTemplateContent(String templateContent)
	{
		this.templateContent = templateContent;
	}

	public void setTemplateName(String templateName)
	{
		this.templateName = templateName;
	}

	public void setTemplateType(TemplateType templateType)
	{
		this.templateType = templateType;
	}

	public void setKeys(String keys)
	{
		this.keys = keys;
	}
}
