package com.alibaba.cloud.k8s.service.impl;


import com.alibaba.cloud.k8s.service.ProviderService;

import org.springframework.stereotype.Service;

/**
 * @author yuluo
 * @author 1481556636@qq.com
 */

@Service
public class ProviderServiceImpl implements ProviderService {

	@Override
	public String service() {

		return "This response from service application";
	}

}
