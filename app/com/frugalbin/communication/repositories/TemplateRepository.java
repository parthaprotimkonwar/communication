package com.frugalbin.communication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frugalbin.communication.models.Template;

public interface TemplateRepository extends JpaRepository<Template, Long>
{

}
