package com.bankapp.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

	//2. configure the cache. bean for cache for : infra bean
	@Bean
	public CacheManager cacheManager() {
		ConcurrentMapCacheManager cacheManager=
				new ConcurrentMapCacheManager("accounts");
		return cacheManager;
	}
}
