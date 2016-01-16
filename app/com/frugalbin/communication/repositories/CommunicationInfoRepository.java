package com.frugalbin.communication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frugalbin.communication.models.CommunicationInfo;

public interface CommunicationInfoRepository<Info extends CommunicationInfo> extends JpaRepository<Info, Long>
{

}
