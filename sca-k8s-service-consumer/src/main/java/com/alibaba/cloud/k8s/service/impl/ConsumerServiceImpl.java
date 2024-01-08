package com.alibaba.cloud.k8s.service.impl;

import com.alibaba.cloud.grpc.lib.RequestBody;
import com.alibaba.cloud.grpc.lib.ResponseBody;
import com.alibaba.cloud.grpc.lib.SCAk8sProviderGrpc;
import com.alibaba.cloud.k8s.service.ConsumerService;
import net.devh.boot.grpc.client.inject.GrpcClient;

import org.springframework.stereotype.Service;

/**
 * @author yuluo
 * @author 1481556636@qq.com
 */

@Service
public class ConsumerServiceImpl implements ConsumerService {

	private static final String CONSUMER_NAME = "sca-k8s-consumer";

	@GrpcClient("sca-k8s-provider")
	SCAk8sProviderGrpc.SCAk8sProviderBlockingStub blockingStub;

	@Override
	public String consumerA() {

		try {
			ResponseBody responseBody =
					blockingStub.providerA(
							RequestBody
									.newBuilder()
									.setConsumer(CONSUMER_NAME + "A")
									.build());
			return responseBody.getMessage();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String consumerB() {

		System.out.println(blockingStub);

		try {
			ResponseBody responseBody = blockingStub.providerB(
					RequestBody
							.newBuilder()
							.setConsumer(CONSUMER_NAME + "B")
							.build());
			return responseBody.getMessage();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
