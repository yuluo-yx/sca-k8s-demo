#!/bin/bash

package() {
  cd application
  docker build -t registry.cn-hangzhou.aliyuncs.com/yuluo-yx/istio-sca-demo-application
}

push() {
  docker tag registry.cn-hangzhou.aliyuncs.com/yuluo-yx/istio-sca-demo-application registry.cn-hangzhou.aliyuncs.com/yuluo-yx/istio-sca-demo-application:latest
  docker push registry.cn-hangzhou.aliyuncs.com/yuluo-yx/istio-sca-demo-application:latest
}

package
push
