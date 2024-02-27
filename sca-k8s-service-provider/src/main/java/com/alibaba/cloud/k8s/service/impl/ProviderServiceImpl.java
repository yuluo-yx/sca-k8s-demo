package com.alibaba.cloud.k8s.service;


import com.alibaba.cloud.k8s.service.impl.ProviderService;

/**
 * @author yuluo
 * @author 1481556636@qq.com
 */

public class ProviderServiceImpl implements ProviderService {

	@Override
	public String providerA() {

		return "This response from provider A!";
	}

	@Override
	public String providerB() {

		return "This response from provider B!";
	}
}
