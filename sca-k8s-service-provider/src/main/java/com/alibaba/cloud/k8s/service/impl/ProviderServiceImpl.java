package com.alibaba.cloud.k8s.service.impl;

import com.alibaba.cloud.grpc.lib.SCAk8sProviderGrpc;
import com.alibaba.cloud.k8s.service.ProviderService;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author yuluo
 * @author 1481556636@qq.com
 */

@GrpcService
public class ProviderServiceImpl extends SCAk8sProviderGrpc.SCAk8sProviderImplBase implements ProviderService {

	@Override
	public String providerA() {

		return "This response from provider A";
	}

	@Override
	public String providerB() {

		return "This response from provider B";
	}

}
