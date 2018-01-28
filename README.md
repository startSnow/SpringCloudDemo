# SpringCloudDemo
Spring Cloud demo 示例工程
| 启动顺序 | 工程名称                               | 说明                              | 端口号  | 访问地址                                 |
| ---- | ---------------------------------- | ------------------------------- | ---- | ------------------------------------ |
| 1    | open-eureka-server                 | 服务注册中心                          | 1111 | http://127.0.0.1:1111                |
| 2    | open-config-server                 | 配置中心                            | 8888 |                                      |
| 2    | open-cloud-admin                   | 应用监控管理                          | 8090 | http://127.0.0.1:8090                |
| 3    | open-cloud-idiom                   | 题库服务，一份代码可运行多个示例                | 2222 | http://127.0.0.1:2222/add            |
| 4    | open-cloud-idiom-ui                | 答题系统，包含了服务调用，两种方式的客户端负载，以及熔断等操作 | 3333 | http://127.0.0.1:2222/add            |
| 5    | open-cloud-idiom-hystrix-dashboard | 可视化的实时的监控，以仪表盘的形式展现，数据可导出       | 4444 | http://127.0.0.1:4444/hystrix.stream |
| 6    | open-cloud-idiom-zuul              | 路由,服务端的负载                       | 5555 | http://127.0.0.1:2222/add            |


