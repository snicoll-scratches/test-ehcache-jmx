package com.example;


import javax.management.MBeanServer;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.management.ManagementService;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class EhCacheJmxConfigurer {

	private final MBeanServer mBeanServer;

	private final CacheManager cacheManager;

	public EhCacheJmxConfigurer(MBeanServer mBeanServer,
			CacheManager cacheManager) {
		this.mBeanServer = mBeanServer;
		this.cacheManager = cacheManager;
	}

	@Bean(initMethod = "init", destroyMethod = "dispose")
	public ManagementService ehCacheManagementService() {
		return new ManagementService(cacheManager, mBeanServer,
				true, true, true, true, true);

	}

}
