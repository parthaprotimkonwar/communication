package com.frugalbin.communication.caches;

import com.frugalbin.communication.services.impl.ServiceFactory;

public interface Cache
{
	void refreshCache();

	void setServiceFactory(ServiceFactory serviceFactory);

	void initializeCache(ServiceFactory serviceFactory);
}
