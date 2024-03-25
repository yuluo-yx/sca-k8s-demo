# Istio 服务部署

这篇文章讲述如何将 Java Spring Cloud 微服务应用部署到 Istio mesh 中。

## 准备基础环境

使用 Kind 模拟 kubernetes 环境。文章参考：https://blog.csdn.net/qq_52397471/article/details/135715485

## 在 kubernetes cluster 中安装 Istio

### 创建一个 k8s cluster

```shell
# 查看 kind 版本
$ kind --version
$ kind version 0.22.0

# 查看 docker 版本
$ docker --version
Docker version 26.0.0, build 2ae903e

# 启动节点
$ kind create cluster name istio-k8s-cluster
# 输出如下表示创建成功
reating cluster "istio-k8s-cluster" ...
 ✓ Ensuring node image (kindest/node:v1.29.2) 🖼 
 ✓ Preparing nodes 📦  
 ✓ Writing configuration 📜 
 ✓ Starting control-plane 🕹️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️️ 
 ✓ Installing CNI 🔌 
 ✓ Installing StorageClass 💾 
Set kubectl context to "kind-istio-k8s-cluster"
You can now use your cluster with:

kubectl cluster-info --context kind-istio-k8s-cluster

Have a nice day! 👋
```

### 安装 Istio

下载：https://github.com/istio/istio/releases/tag/1.21.0

参考：https://istio.io/latest/zh/docs/setup/getting-started/#download

1. 转到 Istio 包目录。例如，如果包是 `istio-1.21.0`：

   ```
   $ cd istio-1.21.0
   ```

   安装目录包含：

   - `samples/` 目录下的示例应用程序
   - `bin/` 目录下的 [`istioctl`](https://istio.io/latest/zh/docs/reference/commands/istioctl) 客户端二进制文件。

2. 将 `istioctl` 客户端添加到路径（Linux 或 macOS）：

   ```
   $ export PATH=$PWD/bin:$PATH
   ```

3. 安装

   ```shell
   # 安装 istio
   root@yuluo-Inspiron-3647:/kubernetes/istio-1.21.0# istioctl install --set profile=demo -y
   ✔ Istio core installed                                             
   ✔ Istiod installed                                              
   ✔ Ingress gateways installed                                          
   ✔ Egress gateways installed                                         
   ✔ Installation complete                                                                                                  Made this installation the default for injection and validation.
   
   # 查看 istio
   root@yuluo-Inspiron-3647:/kubernetes/istio-1.21.0# kubectl get ns
   NAME                   STATUS   AGE
   default                Active   65m
   istio-system           Active   2m23s
   kube-node-lease        Active   65m
   kube-public            Active   65m
   kube-system            Active   65m
   kubernetes-dashboard   Active   59m
   local-path-storage     Active   65m
   root@yuluo-Inspiron-3647:/kubernetes/istio-1.21.0# kubectl get all -n istio-system
   NAME                                        READY   STATUS    RESTARTS   AGE
   pod/istio-egressgateway-b569895b5-j4hlt     1/1     Running   0          2m9s
   pod/istio-ingressgateway-694c4b4d85-dhst9   1/1     Running   0          2m9s
   pod/istiod-8596844f7d-7tvpj                 1/1     Running   0          2m30s
   
   NAME                           TYPE           CLUSTER-IP      EXTERNAL-IP   PORT(S)                                                                      AGE
   service/istio-egressgateway    ClusterIP      10.96.217.217   <none>        80/TCP,443/TCP                                                               2m8s
   service/istio-ingressgateway   LoadBalancer   10.96.60.122    <pending>     15021:31862/TCP,80:30459/TCP,443:30695/TCP,31400:32052/TCP,15443:30184/TCP   2m8s
   service/istiod                 ClusterIP      10.96.141.1     <none>        15010/TCP,15012/TCP,443/TCP,15014/TCP                                        2m30s
   
   NAME                                   READY   UP-TO-DATE   AVAILABLE   AGE
   deployment.apps/istio-egressgateway    1/1     1            1           2m9s
   deployment.apps/istio-ingressgateway   1/1     1            1           2m9s
   deployment.apps/istiod                 1/1     1            1           2m30s
   
   NAME                                              DESIRED   CURRENT   READY   AGE
   replicaset.apps/istio-egressgateway-b569895b5     1         1         1       2m9s
   replicaset.apps/istio-ingressgateway-694c4b4d85   1         1         1       2m9s
   replicaset.apps/istiod-8596844f7d                 1         1         1       2m30s
   
   # 给命名空间添加标签，指示 Istio 在部署应用的时候，自动注入 Envoy 边车代理：
   kubectl label namespace default istio-injection=enabled 
   ```

### 安装 Istio 控制界面 kiali

```shell
kubectl apply -f samples/addons
kubectl rollout status deployment/kiali -n istio-system

# 等待 status 完成
root@yuluo-Inspiron-3647:/kubernetes/istio-1.21.0# kubectl rollout status deployment/kiali -n istio-system
Waiting for deployment "kiali" rollout to finish: 0 of 1 updated replicas are available...
deployment "kiali" successfully rolled out

# 查看安装所有的 istio 组件
kubectl get service -n istio-system

# 访问 kiali 仪表盘
istioctl dashboard kiali

# 通过端口转发访问，grafana 普罗米修斯端口也需要转发
kubectl port-forward -n istio-system service/kiali --address=0.0.0.0 20001:20001
```

访问：http://ip:port/kiali

<img src="D:\project\java_project\sca-k8s-demo\images\image-20240325122657739.png" alt="image-20240325122657739" style="zoom:50%;" />

## 部署应用

### 准备 SCA 应用

pom.xml

```
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
	</dependencies>

	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
			<dependency>
				<groupId>com.alibaba.cloud</groupId>
				<artifactId>spring-cloud-alibaba-dependencies</artifactId>
				<version>${spring-cloud-alibaba.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
```

controller.java

```java
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
```

service java

```java
@Service
public class ProviderServiceImpl implements ProviderService {

    @Override
    public String service() {

       return "This response from service application";
    }

}
```

### 编写 DockerFile

```dockerfile
FROM registry.cn-hangzhou.aliyuncs.com/yuluo-yx/java-base:V20240116

LABEL author="yuluo" \
    email="karashouk.pan@gmail.com"

COPY app.jar /app.jar
COPY application-k8s.yml /application-k8s.yml

ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]
```

将镜像打包上传至 阿里云容器镜像仓库。

### 编写 k8s 部署文件

configMap 外部配置挂载：

```yaml
apiVersion: v1
data:
  spring-profiles-active: 'k8s'
kind: ConfigMap
metadata:
  name: sca-k8s-demo-spring-profile-cm
```

application yaml

```yaml
apiVersion: v1
kind: Service
metadata:
  name: istio-sca-demo-application-svc
  labels:
    app: istio-sca-demo-application
    service: istio-sca-demo-application
spec:
  ports:
    - port: 8080
      targetPort: 8080
      name: http
  type: ClusterIP
  selector:
    app: istio-sca-demo-application

---

apiVersion: apps/v1
kind: Deployment
metadata:
  name: istio-sca-demo-application
  labels:
    app: istio-sca-demo-application
    versions: v1
  # Add the following annotations to enable Istio sidecar injection
  annotations:
    sidecar.istio.io/inject: "true"
spec:
  replicas: 1
  selector:
    matchLabels:
      app: istio-sca-demo-application
  template:
    metadata:
      labels:
        app: istio-sca-demo-application
    spec:
      containers:
        - env:
            - name: SPRING_PROFILES_ACTIVE
              valueFrom:
                configMapKeyRef:
                  name: istio-sca-demo-cm-cm
                  key: spring-profiles-active
            # jvm arguments
            # - name: JAVA_OPTION
            #  value: "-Dfile.encoding=UTF-8 -XX:+UseParallelGC -XX:+PrintGCDetails -Xloggc:/var/log/devops-example.gc.log -XX:+HeapDumpOnOutOfMemoryError -XX:+DisableExplicitGC"
            # - name: XMX
            # value: "128m"
            # - name: XMS
            # value: "128m"
            # - name: XMN
            # value: "64m"
          name: istio-sca-demo-application
          image: registry.cn-hangzhou.aliyuncs.com/yuluo-yx/istio-sca-demo-application:latest
          ports:
            - containerPort: 8080
          livenessProbe:
            httpGet:
              path: /actuator/health
              port: 30001
              scheme: HTTP
            initialDelaySeconds: 20
            periodSeconds: 10
```

### 部署

在 `default` 命名空间开启 istio 自动注入

`kubectl label namespace default istio-injection=enabled`

```shell
root@yuluo-Inspiron-3647:/kubernetes/sca-application# kubectl get ns -L istio-injection
NAME                   STATUS   AGE    ISTIO-INJECTION
default                Active   179m   enabled
istio-system           Active   116m   
kube-node-lease        Active   179m   
kube-public            Active   179m   
kube-system            Active   179m   
kubernetes-dashboard   Active   173m   
local-path-storage     Active   179m   
```

执行以下命令部署服务：

```shell
kubectl apply -f istio-sca-demo-cm.yaml
kubectl apply -f istio-sca-demo-application.yaml
```

查看部署结果

```shell
root@yuluo-Inspiron-3647:/kubernetes/sca-application# kubectl get pods -l app=istio-sca-demo-application
NAME                                          READY   STATUS    RESTARTS   AGE
istio-sca-demo-application-797684cc96-5tl7b   2/2     Running   0          85s
```

在开启了 istio 自动注入之后，就会有两个容器，一个为应用本身，一个为 sidecar 边车代理。

在 describe 中可以看到注入时的信息：

```shell
$ kubectl describe pod istio-sca-demo-application-797684cc96-5tl7b

# 输出内容截取 即为 istio sidecar
  istio-proxy:
    Container ID:  containerd://26e95eaa56904faeb183f0cad53165354b789b44294aa898c16ab3da0d0f09b3
    Image:         docker.io/istio/proxyv2:1.21.0
    Image ID:      docker.io/istio/proxyv2@sha256:1b10ab67aa311bcde7ebc18477d31cc73d8169ad7f3447d86c40a2b056c456e4
    Port:          15090/TCP
    Host Port:     0/TCP
    Args:
      proxy
      sidecar
      --domain
      $(POD_NAMESPACE).svc.cluster.local
      --proxyLogLevel=warning
      --proxyComponentLogLevel=misc:error
      --log_output_level=default:info
    State:          Running
      Started:      Mon, 25 Mar 2024 14:00:02 +0800
    Ready:          True
    Restart Count:  0
```

我们在 kiali 中可以查看到 envoy sidecar 注入的日志信息：

```shell
:: Spring Boot ::                (v3.0.9)
2024-03-25T06:00:03.486Z  INFO 1 --- [           main] c.a.cloud.k8s.IstioDemoApplication       : Starting IstioDemoApplication v2024.01.08 using Java 17.0.10 with PID 1 (/app.jar started by root in /)
2024-03-25T06:00:03.489Z  INFO 1 --- [           main] c.a.cloud.k8s.IstioDemoApplication       : The following 1 profile is active: "k8s"

# 如下所示
2024-03-25T06:00:03.985996Z	info	Readiness succeeded in 1.703126315s
2024-03-25T06:00:03.988340Z	info	Envoy proxy is ready

2024-03-25T06:00:05.314Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
```

测试访问

`kubectl port-forward svc/istio-sca-demo-application-svc --address 0.0.0.0 8080:8080`

```shell
root@yuluo-Inspiron-3647:/kubernetes/kind# curl 192.168.2.10:8080/app/svc
This response from service applicationroot
```

服务部署成功！

## 总结

```shell
root@yuluo-Inspiron-3647:/kubernetes/sca-application# kubectl get pods -A
NAMESPACE              NAME                                                      READY   STATUS    RESTARTS   AGE
default                istio-sca-demo-application-797684cc96-5tl7b               2/2     Running   0          5m38s
default                loki-0                                                    2/2     Running   0          129m
default                sleep-7656cf8794-dx7zm                                    2/2     Running   0          14m
istio-system           grafana-6f68dfd8f4-pf48z                                  1/1     Running   0          129m
istio-system           istio-egressgateway-b569895b5-j4hlt                       1/1     Running   0          147m
istio-system           istio-ingressgateway-694c4b4d85-dhst9                     1/1     Running   0          147m
istio-system           istiod-8596844f7d-7tvpj                                   1/1     Running   0          147m
istio-system           jaeger-7d7d59b9d-s5chv                                    1/1     Running   0          129m
istio-system           kiali-588bc98cd-gqmnr                                     1/1     Running   0          129m
istio-system           prometheus-7545dd48db-kvmrm                               2/2     Running   0          129m
kube-system            coredns-76f75df574-jxl2w                                  1/1     Running   0          3h30m
kube-system            coredns-76f75df574-r8bxm                                  1/1     Running   0          3h30m
kube-system            etcd-istio-k8s-cluster-control-plane                      1/1     Running   0          3h30m
kube-system            kindnet-zh4t9                                             1/1     Running   0          3h30m
kube-system            kube-apiserver-istio-k8s-cluster-control-plane            1/1     Running   0          3h30m
kube-system            kube-controller-manager-istio-k8s-cluster-control-plane   1/1     Running   0          3h31m
kube-system            kube-proxy-kn666                                          1/1     Running   0          3h30m
kube-system            kube-scheduler-istio-k8s-cluster-control-plane            1/1     Running   0          3h30m
kubernetes-dashboard   dashboard-metrics-scraper-5657497c4c-jdqfg                1/1     Running   0          3h24m
kubernetes-dashboard   kubernetes-dashboard-78f87ddfc-phmt6                      1/1     Running   0          3h24m
local-path-storage     local-path-provisioner-7577fdbbfb-sjp54                   1/1     Running   0          3h30m
```

以上便是上述文章中部署的所有 pod。kiali 中显示出了应用的具体信息：

<img src="D:\project\java_project\sca-k8s-demo\images\image-20240325140608310.png" alt="image-20240325140608310" style="zoom:50%;" />

