package com.example;


import javax.annotation.PostConstruct;
import javax.management.MBeanServer;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.management.ManagementService;

import org.springframework.stereotype.Service;

@Service
public class EhCacheJmxConfigurer {

	private final MBeanServer mBeanServer;

	private final CacheManager cacheManager;

	public EhCacheJmxConfigurer(MBeanServer mBeanServer, CacheManager cacheManager) {
		this.mBeanServer = mBeanServer;
		this.cacheManager = cacheManager;
	}

	@PostConstruct
	public void initializeJmx() {
		ManagementService.registerMBeans(cacheManager, mBeanServer,
				true, true, true, true, true);
	}

}
