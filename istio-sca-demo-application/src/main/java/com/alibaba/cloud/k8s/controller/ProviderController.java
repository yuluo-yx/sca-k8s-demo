package com.alibaba.cloud.k8s.controller;

import com.alibaba.cloud.k8s.service.ProviderService;
import jakarta.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuluo
 * @author 1481556636@qq.com
 */

@RestController
@RequestMapping("/app")
public class ProviderController {

	@Resource
	protected ProviderService providerService;

	@GetMapping("/svc")
	public String providerA() {

		return providerService.service();
	}

}
