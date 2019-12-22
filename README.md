# 微服务demo
## 整体父工程Project - microservicecloud
### 公共子模块Module
microservicecloud-api

### 部门微服务提供者Module
microservicecloud-provider-dept-8001

### 部门微服务消费者Module
microservicecloud-consumer-dept-80

### Eureka服务注册中心Module(配置集群)
microservicecloud-eureka-7001
microservicecloud-eureka-7002
microservicecloud-eureka-7003

### Ribbon负载均衡配置
修改consumer80模块
新建两个部门微服务提供者provider8002与provider8003

### Feign负载均衡
仿照consumer80新建microservicecloud-consumer-dept-feign模块

### Hystrix断路器(服务熔断 和 服务降级)
仿照provider8001新建microservicecloud-provider-dept-hystrix-8001

### HystrixDashboard服务监控
microservicecloud-consumer-hystrix-dashboard

### Zuul路由网关
microservicecloud-zuul-gateway-9527

### Config分布式配置中心
Github仓库microservicecloud-config
Config服务端配置中心模块 - microservicecloud-config-3344
Config客户端模块 - microservicecloud-config-client-3355

### Config分布式配置中心具体示例
在config-3344和config-client-3355搭好的基础上
Config版的eureka服务端 - microservicecloud-config-eureka-client-7001
Config版的dept微服务 - microservicecloud-config-dept-client-8001


