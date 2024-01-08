package com.alibaba.cloud.grpc.lib;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.34.1)",
    comments = "Source: sca-k8s.proto")
public final class SCAk8sProviderGrpc {

  private SCAk8sProviderGrpc() {}

  public static final String SERVICE_NAME = "SCAk8sProvider";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.alibaba.cloud.grpc.lib.RequestBody,
      com.alibaba.cloud.grpc.lib.ResponseBody> getProviderAMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "providerA",
      requestType = com.alibaba.cloud.grpc.lib.RequestBody.class,
      responseType = com.alibaba.cloud.grpc.lib.ResponseBody.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.alibaba.cloud.grpc.lib.RequestBody,
      com.alibaba.cloud.grpc.lib.ResponseBody> getProviderAMethod() {
    io.grpc.MethodDescriptor<com.alibaba.cloud.grpc.lib.RequestBody, com.alibaba.cloud.grpc.lib.ResponseBody> getProviderAMethod;
    if ((getProviderAMethod = SCAk8sProviderGrpc.getProviderAMethod) == null) {
      synchronized (SCAk8sProviderGrpc.class) {
        if ((getProviderAMethod = SCAk8sProviderGrpc.getProviderAMethod) == null) {
          SCAk8sProviderGrpc.getProviderAMethod = getProviderAMethod =
              io.grpc.MethodDescriptor.<com.alibaba.cloud.grpc.lib.RequestBody, com.alibaba.cloud.grpc.lib.ResponseBody>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "providerA"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.alibaba.cloud.grpc.lib.RequestBody.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.alibaba.cloud.grpc.lib.ResponseBody.getDefaultInstance()))
              .setSchemaDescriptor(new SCAk8sProviderMethodDescriptorSupplier("providerA"))
              .build();
        }
      }
    }
    return getProviderAMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.alibaba.cloud.grpc.lib.RequestBody,
      com.alibaba.cloud.grpc.lib.ResponseBody> getProviderBMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "providerB",
      requestType = com.alibaba.cloud.grpc.lib.RequestBody.class,
      responseType = com.alibaba.cloud.grpc.lib.ResponseBody.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.alibaba.cloud.grpc.lib.RequestBody,
      com.alibaba.cloud.grpc.lib.ResponseBody> getProviderBMethod() {
    io.grpc.MethodDescriptor<com.alibaba.cloud.grpc.lib.RequestBody, com.alibaba.cloud.grpc.lib.ResponseBody> getProviderBMethod;
    if ((getProviderBMethod = SCAk8sProviderGrpc.getProviderBMethod) == null) {
      synchronized (SCAk8sProviderGrpc.class) {
        if ((getProviderBMethod = SCAk8sProviderGrpc.getProviderBMethod) == null) {
          SCAk8sProviderGrpc.getProviderBMethod = getProviderBMethod =
              io.grpc.MethodDescriptor.<com.alibaba.cloud.grpc.lib.RequestBody, com.alibaba.cloud.grpc.lib.ResponseBody>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "providerB"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.alibaba.cloud.grpc.lib.RequestBody.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.alibaba.cloud.grpc.lib.ResponseBody.getDefaultInstance()))
              .setSchemaDescriptor(new SCAk8sProviderMethodDescriptorSupplier("providerB"))
              .build();
        }
      }
    }
    return getProviderBMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SCAk8sProviderStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SCAk8sProviderStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SCAk8sProviderStub>() {
        @java.lang.Override
        public SCAk8sProviderStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SCAk8sProviderStub(channel, callOptions);
        }
      };
    return SCAk8sProviderStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SCAk8sProviderBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SCAk8sProviderBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SCAk8sProviderBlockingStub>() {
        @java.lang.Override
        public SCAk8sProviderBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SCAk8sProviderBlockingStub(channel, callOptions);
        }
      };
    return SCAk8sProviderBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SCAk8sProviderFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SCAk8sProviderFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SCAk8sProviderFutureStub>() {
        @java.lang.Override
        public SCAk8sProviderFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SCAk8sProviderFutureStub(channel, callOptions);
        }
      };
    return SCAk8sProviderFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SCAk8sProviderImplBase implements io.grpc.BindableService {

    /**
     */
    public void providerA(com.alibaba.cloud.grpc.lib.RequestBody request,
        io.grpc.stub.StreamObserver<com.alibaba.cloud.grpc.lib.ResponseBody> responseObserver) {
      asyncUnimplementedUnaryCall(getProviderAMethod(), responseObserver);
    }

    /**
     */
    public void providerB(com.alibaba.cloud.grpc.lib.RequestBody request,
        io.grpc.stub.StreamObserver<com.alibaba.cloud.grpc.lib.ResponseBody> responseObserver) {
      asyncUnimplementedUnaryCall(getProviderBMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getProviderAMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.alibaba.cloud.grpc.lib.RequestBody,
                com.alibaba.cloud.grpc.lib.ResponseBody>(
                  this, METHODID_PROVIDER_A)))
          .addMethod(
            getProviderBMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.alibaba.cloud.grpc.lib.RequestBody,
                com.alibaba.cloud.grpc.lib.ResponseBody>(
                  this, METHODID_PROVIDER_B)))
          .build();
    }
  }

  /**
   */
  public static final class SCAk8sProviderStub extends io.grpc.stub.AbstractAsyncStub<SCAk8sProviderStub> {
    private SCAk8sProviderStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SCAk8sProviderStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SCAk8sProviderStub(channel, callOptions);
    }

    /**
     */
    public void providerA(com.alibaba.cloud.grpc.lib.RequestBody request,
        io.grpc.stub.StreamObserver<com.alibaba.cloud.grpc.lib.ResponseBody> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProviderAMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void providerB(com.alibaba.cloud.grpc.lib.RequestBody request,
        io.grpc.stub.StreamObserver<com.alibaba.cloud.grpc.lib.ResponseBody> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProviderBMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SCAk8sProviderBlockingStub extends io.grpc.stub.AbstractBlockingStub<SCAk8sProviderBlockingStub> {
    private SCAk8sProviderBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SCAk8sProviderBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SCAk8sProviderBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.alibaba.cloud.grpc.lib.ResponseBody providerA(com.alibaba.cloud.grpc.lib.RequestBody request) {
      return blockingUnaryCall(
          getChannel(), getProviderAMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.alibaba.cloud.grpc.lib.ResponseBody providerB(com.alibaba.cloud.grpc.lib.RequestBody request) {
      return blockingUnaryCall(
          getChannel(), getProviderBMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SCAk8sProviderFutureStub extends io.grpc.stub.AbstractFutureStub<SCAk8sProviderFutureStub> {
    private SCAk8sProviderFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SCAk8sProviderFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SCAk8sProviderFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.alibaba.cloud.grpc.lib.ResponseBody> providerA(
        com.alibaba.cloud.grpc.lib.RequestBody request) {
      return futureUnaryCall(
          getChannel().newCall(getProviderAMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.alibaba.cloud.grpc.lib.ResponseBody> providerB(
        com.alibaba.cloud.grpc.lib.RequestBody request) {
      return futureUnaryCall(
          getChannel().newCall(getProviderBMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PROVIDER_A = 0;
  private static final int METHODID_PROVIDER_B = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SCAk8sProviderImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SCAk8sProviderImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROVIDER_A:
          serviceImpl.providerA((com.alibaba.cloud.grpc.lib.RequestBody) request,
              (io.grpc.stub.StreamObserver<com.alibaba.cloud.grpc.lib.ResponseBody>) responseObserver);
          break;
        case METHODID_PROVIDER_B:
          serviceImpl.providerB((com.alibaba.cloud.grpc.lib.RequestBody) request,
              (io.grpc.stub.StreamObserver<com.alibaba.cloud.grpc.lib.ResponseBody>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SCAk8sProviderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SCAk8sProviderBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.alibaba.cloud.grpc.lib.ScaK8sProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SCAk8sProvider");
    }
  }

  private static final class SCAk8sProviderFileDescriptorSupplier
      extends SCAk8sProviderBaseDescriptorSupplier {
    SCAk8sProviderFileDescriptorSupplier() {}
  }

  private static final class SCAk8sProviderMethodDescriptorSupplier
      extends SCAk8sProviderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SCAk8sProviderMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SCAk8sProviderGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SCAk8sProviderFileDescriptorSupplier())
              .addMethod(getProviderAMethod())
              .addMethod(getProviderBMethod())
              .build();
        }
      }
    }
    return result;
  }
}
