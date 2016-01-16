package com.frugalbin.communication.services;

import java.util.List;

import com.frugalbin.communication.models.Template;

public interface TemplateServiceI
{
	List<Template> getTemplateList();

	Template insertTemplate(Template template);
}
