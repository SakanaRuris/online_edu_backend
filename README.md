# online_edu_backend
The backend of an online education website。基于SpringBoot的项目，采用B2C的商业模块，使用微服务架构，项目采用前后端分离技术；项目分为前台用户系统和后台管理系统。
# 谷粒学院

![](https://img.shields.io/badge/building-passing-green.svg)![GitHub](https://img.shields.io/badge/license-MIT-yellow.svg)![jdk](https://img.shields.io/static/v1?label=oraclejdk&message=8&color=blue)

谷粒学院项目致力于打造一个B2C模式的职业技能在线教育系统平台，采用现阶段流行技术来实现，采用前后端分离编写。


## 项目介绍

谷粒学院项目是一套在线教育项目，包括前台系统以及后台管理系统，基于 SpringCloud、SpringCloud Alibaba、MyBatis Plus实现。前台系统包括：用户登录、注册、名师列表、名师详情、课程列表、课程详细、视频在线播放等模块。后台管理系统包括：首页、权限管理、讲师分类、课程分类、课程管理、统计分析等模块。



## 系统架构

**架构设计需要考虑的几个方面：**

- **性能：**主要考虑访问频率，每个用户每天的访问次数。项目初始阶段用户的访问量并不大，如果考虑做运营推广，可能会迎来服务器访问量骤增，因此要考虑\**分布式部署，引入缓存
- **可扩展性：**系统功能会随着用户量的增加以及多变的互联网用户需求不断地扩展，因此考虑到系统的可扩展性的要求需要使用微服务架构，引入消息中间件
- **高可用：**系统一旦宕机，将会带来不可挽回的损失，因此必须做负载均衡，甚至是异地多活这类复杂的方案。如果数据丢失，修复将会非常麻烦，只能靠人工逐条修复，这个很难接受，因此需要考虑存储高可靠。我们需要考虑多种异常情况：机器故障、机房故障，针对机器故障，我们需要设计 MySQL 同机房主备方案；针对机房故障，我们需要设计 MySQL 跨机房同步方案。
- **安全性：**系统的信息有一定的隐私性，例如用户的个人身份信息，不包含强隐私（例如玉照、情感）的信息，因此使用账号密码管理、数据库访问权限控制即可。
- **成本：**视频类网站的主要成本在于服务器成本、流量成本、存储成本、流媒体研发成本，中小型公司可以考虑使用云服务器和云服务。


## 项目演示

### 前台商品系统

#### 首页

![image-20210427222911174](https://oss.imoyt.top/img/20210427222912.png)

#### 登录注册

<div>
    <img src="https://guliedu-2002.oss-ap-northeast-1.aliyuncs.com/course/login.png" style="zoom:60%;" />
    <img src="https://guliedu-2002.oss-ap-northeast-1.aliyuncs.com/course/register.png" style="zoom:60%;" />
</div>

#### 课程详情

![image-20210427230357729](https://oss.imoyt.top/img/20210427230358.png)

#### **课程详情页**

![image-20210427230447521](https://oss.imoyt.top/img/20210427230448.png)


#### 名师列表功能

![image-20210427232117899](https://oss.imoyt.top/img/20210427232119.png)

#### 名师详情功能

![image-20210427232154948](https://oss.imoyt.top/img/20210427232156.png)


### 后台管理系统

#### 登录

![image-20210427173911453](https://oss.imoyt.top/img/20210427173912.png)

#### 数据库信息的管理

<div>
     <img src="" style="zoom:40%;" />
    <img src="https://oss.imoyt.top/img/20210427174750.png" style="zoom:40%;" />
    <img src="https://oss.imoyt.top/img/20210427174934.png" style="zoom:70%;" />
    <img src="https://oss.imoyt.top/img/20210427174954.png" style="zoom:60%;" />
    <img src="https://oss.imoyt.top/img/20210427175011.png" style="zoom:50%;" />
</div>




## 组织结构

`后端`

```
guli-parent
├─common  
│  └─common_utils -- 通用静态方法 
│  └─service_base -- 基础服务
├─service-edu -- 核心服务模块
├─service_cms -- 幻灯片管理模块
├─service_msm -- 短信模块
├─service_order -- 订单模块
├─service_oss -- 阿里OSS模块
├─service_ucenter -- 会员模块
└─infrastructure 
    └─api_gateway -- 网关模块
```

`前端`

~~~
guli-web
├─ guli_admin  -- 后台UI
└─ guli_front  -- 前台UI
~~~

## 技术选型

### 后端技术

|        技术        |     说明      |                      官网                       |
| :----------------: | :-----------: | :---------------------------------------------: |
|     SpringBoot     | 容器+MVC框架  |     https://spring.io/projects/spring-boot      |
|    SpringCloud     |  微服务架构   |     https://spring.io/projects/spring-cloud     |
| SpringCloudAlibaba |  一系列组件   | https://spring.io/projects/spring-cloud-alibaba |
|    MyBatis-Plus    |    ORM框架    |             https://mp.baomidou.com             |
|        OSS         |  对象云存储   |  https://github.com/aliyun/aliyun-oss-java-sdk  |
|     EasyExcel      | 处理Excel工具 |       https://www.yuque.com/easyexcel/doc       |
|       Docker       | 应用容器引擎  |             https://www.docker.com              |

### 前端技术

|    技术    |      说明      |                   官网                   |
| :--------: | :------------: | :--------------------------------------: |
|    Vue     |    前端框架    |            https://vuejs.org             |
| Element-ui |   前端UI框架   |     https://element.eleme.cn/#/zh-CN     |
|    Nuxt    |   前端UI框架   |          https://zh.nuxtjs.org/          |
|  node.js   |   服务端的js   |          https://nodejs.org/en           |
|  Echarts   | 数据可视化图表 | https://echarts.apache.org/zh/index.html |

## 环境搭建

### 开发工具

|       工具        |        说明         |                                官网                                |
|:---------------:| :-----------------: |:----------------------------------------------------------------:|
|      IDEA       |    开发Java程序     |             https://www.jetbrains.com/idea/download              |
|  RedisDesktop   | redis客户端连接工具 |                https://redisdesktop.com/download                 |
|     X-shell     |  Linux远程连接工具  |         http://www.netsarang.com/download/software.html          |
|     Navicat     |   数据库连接工具    |               http://www.formysql.com/xiazai.html                |
| MySQL Workbench |   数据库设计工具    |             https://www.mysql.com/products/workbench             |
|     Postman     |   API接口调试工具   |                     https://www.postman.com                      |
|     Typora      |   Markdown编辑器    |                        https://typora.io                         |

### 开发环境

| 工具  | 版本号 |                             下载                             |
| :---: | :----: | :----------------------------------------------------------: |
|  JDK  |  1.8   | https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html |
| Mysql |  5.7   |                    https://www.mysql.com                     |
| Redis | Redis  |                  https://redis.io/download                   |
| Nginx | 1.1.6  |              http://nginx.org/en/download.html               |

`注意：`以上的除了jdk都是采用docker方式进行安装，详细安装步骤可参考百度!!!

​				Nginx 可以不使用，本项目后期都替换了使用GateWay 来作为网关

### 搭建步骤

>准备工作

IDEA，Visual Studio Code，JDK >= 1.8 (推荐1.8版本)， Mysql >= 5.7， Maven

> Windows环境部署

- 必须先启动 先启动 **nacos** 注册中心

  ![image-20210427233515155](https://oss.imoyt.top/img/20210427233516.png)

>后端启动

* 克隆整个后端项目` GuliEdu`，并导入 IDEA 中完成编译

~~~
https://github.com/SakanaRuris/online_edu_backend.git
~~~

* 创建数据库guli_edu并导入数据脚本sql / **

  ![image-20210428001500053](https://oss.imoyt.top/img/20210428004954.png)

* 修改各个模块的application.properties文件的MySQL配置信息

~~~properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/你的数据库名称?autoReconnect=true&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8
spring.datasource.username=root
spring.datasource.password=你的密码
~~~

* 修改各个模块的application.properties文件的Redis配置信息

~~~properties
spring.redis.host=redis IP 地址
spring.redis.port=6379
spring.redis.database= 0
spring.redis.timeout=1800000
~~~

* 修改 service_oss 模块的application.properties文件，阿里OSS的 endpoint、 keyid、keysecret、bucketname、filehost

~~~properties
#阿里云 OSS
#不同的服务器，地址不同
aliyun.oss.file.endpoint=oss-cn-shenzhen.aliyuncs.com
aliyun.oss.file.keyid=<you keyid>
aliyun.oss.file.keysecret=<you keysecret>
#bucket可以在控制台创建，也可以使用java代码创建
aliyun.oss.file.bucketname=oypicbed
aliyun.oss.file.filehost=ossTest
~~~

>**启动后台管理UI**

* https://github.com/SakanaRuris/online_edu_admin_frontend.git

>**启动前台Web UI**

* https://github.com/SakanaRuris/online_edu_client_frontend.git

