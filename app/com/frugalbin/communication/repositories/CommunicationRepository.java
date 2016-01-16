package com.frugalbin.communication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frugalbin.communication.models.Communication;

public interface CommunicationRepository extends JpaRepository<Communication, Long>
{

}
