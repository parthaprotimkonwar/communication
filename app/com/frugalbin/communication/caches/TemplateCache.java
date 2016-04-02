package com.frugalbin.communication.caches;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.frugalbin.communication.models.Template;
import com.frugalbin.communication.models.helpers.CommunicationType;
import com.frugalbin.communication.services.impl.ServiceFactory;

public class TemplateCache extends AbstractCache
{
	private static volatile TemplateCache instance;

	private Map<Long, Template> templateMap = new HashMap<Long, Template>();

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
		template.setTemplateType(CommunicationType.EMAIL_SMS);
		template.setKeys("%NAME%");
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
	}

	public Template getTemplate(Long templateId)
	{
		return templateMap.get(templateId);
	}
}