package com.frugalbin.communication.caches;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.frugalbin.common.enums.TemplateNames;
import com.frugalbin.communication.models.Template;
import com.frugalbin.communication.models.helpers.CommunicationType;
import com.frugalbin.communication.services.impl.ServiceFactory;

public class TemplateCache extends AbstractCache
{
	private static volatile TemplateCache instance;

	private Map<Long, Template> templateMap = new HashMap<Long, Template>();

	private Map<String, Template> templateNameMap = new HashMap<String, Template>();

	private TemplateCache()
	{
	}

	public static TemplateCache getInstance()
	{
		if (instance == null)
		{
			synchronized (TemplateCache.class)
			{
				if (instance == null)
				{
					instance = new TemplateCache();
				}
			}
		}

		return instance;
	}

	@Override
	public void initializeCache(ServiceFactory serviceFactory)
	{
		super.initializeCache(serviceFactory);

		// TODO: Remove this when using actual DB
		Template template = new Template();
		template.setTemplateId(1L);
		template.setTemplateContent("Test Content %NAME%");
		template.setTemplateName("TEST");
		template.setTemplateType(CommunicationType.EMAIL);
		template.setKeys("%NAME%");
		this.serviceFactory.getTemplateService().insertTemplate(template);

		template = new Template();
		template.setTemplateId(2L);
		template.setTemplateContent("Click on the following link to get request link to uesr: "
				+ "http://ec2-52-37-173-141.us-west-2.compute.amazonaws.com:8080/frugalbin/homepage9.html#/flight_list/list/%RequestId%");
		template.setTemplateName(TemplateNames.USER_REQUEST_LINK.name());
		template.setTemplateType(CommunicationType.EMAIL);
		template.setKeys("%RequestId%");
		this.serviceFactory.getTemplateService().insertTemplate(template);

		template = new Template();
		template.setTemplateId(3L);
		template.setTemplateContent("Click on the following link to send request link to uesr: "
				+ "http://ec2-52-37-173-141.us-west-2.compute.amazonaws.com:9002/frugalbin/sendRequestedFlightLink?requestId=%RequestId%");
		template.setTemplateName(TemplateNames.SEND_USER_REQUEST_LINK.name());
		template.setTemplateType(CommunicationType.EMAIL);
		template.setKeys("%RequestId%");
		this.serviceFactory.getTemplateService().insertTemplate(template);
	}

	@Override
	public void refreshCache()
	{
		List<Template> templateList = serviceFactory.getTemplateService().getTemplateList();

		for (Template template : templateList)
		{
			templateMap.put(template.getTemplateId(), template);
		}

		for (Template template : templateList)
		{
			templateNameMap.put(template.getTemplateName(), template);
		}
	}

	public Template getTemplate(Long templateId)
	{
		return templateMap.get(templateId);
	}

	public Template getTemplate(String templateName)
	{
		return templateNameMap.get(templateName);
	}
}