package com.frugalbin.communication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frugalbin.communication.models.CommunicationConnectionInfo;

public interface CommunicationConnectionInfoRepository extends JpaRepository<CommunicationConnectionInfo, Long>
{

}
