package com.frugalbin.communication.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.frugalbin.communication.models.Template;
import com.frugalbin.communication.repositories.TemplateRepository;
import com.frugalbin.communication.services.TemplateServiceI;

@Named
@Singleton
public class TemplateServiceImpl implements TemplateServiceI
{
	@Inject
	private TemplateRepository templateRepository;

	@Override
	public List<Template> getTemplateList()
	{
		return templateRepository.findAll();
	}

	@Override
	public Template insertTemplate(Template template)
	{
		Template savedTemplate = templateRepository.saveAndFlush(template);
		return savedTemplate;
	}
}
