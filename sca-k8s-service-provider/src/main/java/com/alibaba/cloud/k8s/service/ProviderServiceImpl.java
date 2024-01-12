package com.alibaba.cloud.k8s.service;

import com.alibaba.cloud.grpc.lib.RequestBody;
import com.alibaba.cloud.grpc.lib.ResponseBody;
import com.alibaba.cloud.grpc.lib.SCAk8sProviderGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author yuluo
 * @author 1481556636@qq.com
 */

@GrpcService
public class ProviderServiceImpl extends SCAk8sProviderGrpc.SCAk8sProviderImplBase {

	@Override
	public void providerA(RequestBody request, StreamObserver<ResponseBody> responseObserver) {

		responseObserver.onNext(
				ResponseBody
						.newBuilder()
						.setMessage("This response from provider A!")
						.build()
		);

		responseObserver.onCompleted();
	}

	@Override
	public void providerB(RequestBody request, StreamObserver<ResponseBody> responseObserver) {

		responseObserver.onNext(
				ResponseBody
						.newBuilder()
						.setMessage("This response from provider B!")
						.build()
		);
		responseObserver.onCompleted();
	}
}
