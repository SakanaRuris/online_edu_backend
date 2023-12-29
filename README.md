# Online Education Website


The online education website is committed to building a B2C model vocational skills online education system platform, which is implemented using current popular technologies and written separately from the front and back ends.




## Project Introduction

This project is an online education project, including a front-end system and a back-end management system, implemented based on SpringBoot, SpringCloud, SpringCloud Alibaba, and MyBatis Plus. The front-end system includes: user login, registration, famous teacher list, famous teacher details, course list, course details, video online playback and other modules. The backend management system includes: home page, authority management, lecturer classification, course classification, course management, statistical analysis and other modules.


## System Structure

**Several aspects that need to be considered in architectural design：**

- **performance：**Mainly consider the frequency of access, the number of visits per user per day. The number of user visits in the initial stage of the project is not large. If you consider doing operation and promotion, you may experience a sudden increase in server visits, so you must consider\**Distributed deployment, introducing cache
- **Scalability：**System functions will continue to expand with the increase in the number of users and changing Internet user needs. Therefore, considering the scalability requirements of the system, it is necessary to use a microservice architecture and introduce message middleware



## Project Demonstration

### Front Desk Merchandise System

#### Front Page

![image-20210427222911174](https://oss.imoyt.top/img/20210427222912.png)

#### Login and Register

<div>
    <img src="https://guliedu-2002.oss-ap-northeast-1.aliyuncs.com/course/login.png" style="zoom:60%;"  />
    <img src="https://guliedu-2002.oss-ap-northeast-1.aliyuncs.com/course/register.png" style="zoom:60%;" />
</div>

#### Course Details

![image-20210427230357729](https://oss.imoyt.top/img/20210427230358.png)

#### **Course Details Page**

![image-20210427230447521](https://oss.imoyt.top/img/20210427230448.png)


#### Famous Teacher List

![image-20210427232117899](https://oss.imoyt.top/img/20210427232119.png)

#### Famous Teacher Details

![image-20210427232154948](https://oss.imoyt.top/img/20210427232156.png)


### Backend Management System

#### Database Information Management

<div>
     <img src="" style="zoom:40%;" />
    <img src="https://oss.imoyt.top/img/20210427174750.png" style="zoom:40%;" />
    <img src="https://oss.imoyt.top/img/20210427174934.png" style="zoom:70%;" />
    <img src="https://oss.imoyt.top/img/20210427174954.png" style="zoom:60%;" />
    <img src="https://oss.imoyt.top/img/20210427175011.png" style="zoom:50%;" />
</div>




## Organizational Structure

`Backend`

```
guli-parent
├─common  
│  └─common_utils -- Generic static method 
│  └─service_base -- Basic services
├─service-edu -- Core service module
├─service_cms -- Slide management module
├─service_msm -- SMS module
├─service_order -- Order module
├─service_oss -- Alibaba OSS module
├─service_ucenter -- Member module
└─infrastructure 
    └─api_gateway -- Gateway module
```

`Frontend`

~~~
guli-web
├─ guli_admin  -- Backend UI
└─ guli_front  -- Front UI
~~~




### Building steps

>Preparation

IDEA，Visual Studio Code，JDK >= 1.8 (recommended version 1.8)， Mysql >= 5.7， Maven

> Windows environment deployment

- The **nacos** registration center must be started first

  ![image-20210427233515155](https://oss.imoyt.top/img/20210427233516.png)

>Backend startup

* Clone the entire backend project `online_edu_backend` and import it into IDEA to complete the compilation

~~~
https://github.com/SakanaRuris/online_edu_backend.git
~~~

* Modify the MySQL configuration information of the application.properties file of each module

~~~properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/你的数据库名称?autoReconnect=true&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8
spring.datasource.username=root
spring.datasource.password=你的密码
~~~

* Modify the Redis configuration information of the application.properties file of each module

~~~properties
spring.redis.host=redis IP 地址
spring.redis.port=6379
spring.redis.database= 0
spring.redis.timeout=1800000
~~~

* Modify the application.properties file of the service_oss module, the endpoint, keyid, keysecret, bucketname, and filehost of Alibaba OSS.

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

>**Start the backend management UI**

* https://github.com/SakanaRuris/online_edu_admin_frontend.git

>**Start the frontend Web UI**

* https://github.com/SakanaRuris/online_edu_client_frontend.git

