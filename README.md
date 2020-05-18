[TOC]



# SpringBoot相关

## SpringBoot基础

### SpringBoot介绍

​	   [百度百科](https://baike.baidu.com/item/Spring Boot/20249767?fr=aladdin) 

 	 Spring Boot 是由 Pivotal[ˈpɪvətl]团队（一家做大数据的公司） 提供的全新框架，其设计
目的是用来简化新 Spring 应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配
置，从而使开发人员不再需要定义样板化的配置。通过这种方式， Spring Boot 致力于在蓬勃发展的快速应用开发领域(rapid application development)成为领导者。
简单来说， SpringBoot 可以简化 Spring 应用程序的开发，使我们不再需要 Spring 配置文
件及 web.xml 文件  

 SpringBoot是由Pivotal团队在2013年开始研发、2014年4月发布第一个版本的全新开源的轻量级框架。它基于Spring4.0设计，不仅继承了Spring框架原有的优秀特性，而且还通过简化配置来进一步简化了Spring应用的整个搭建和开发过程。另外SpringBoot通过集成大量的框架使得依赖包的版本冲突，以及引用的不稳定性等问题得到了很好的解决。 

​	SpringBoot所具备的特征有：

（1）可以创建独立的[Spring](https://baike.baidu.com/item/Spring/85061)应用程序，并且基于其Maven或Gradle插件，可以创建可执行的JARs和WARs；

（2）内嵌Tomcat或Jetty等Servlet容器；

（3）提供自动配置的“starter”项目对象模型（POMS）以简化[Maven](https://baike.baidu.com/item/Maven/6094909)配置；

（4）尽可能自动配置Spring容器；

（5）提供准备好的特性，如指标、健康检查和外部化配置；

（6）绝对没有代码生成，不需要XML配置

​	 SpringBoot框架中还有两个非常重要的策略：开箱即用和约定优于配置。开箱即用，Outofbox，是指在开发过程中，通过在MAVEN项目的pom文件中添加相关依赖包，然后使用对应注解来代替繁琐的XML配置文件以管理对象的生命周期。这个特点使得开发人员摆脱了复杂的配置工作以及依赖的管理工作，更加专注于业务逻辑。约定优于配置，Convention over configuration，是一种由SpringBoot本身来配置目标结构，由开发者在结构中添加信息的软件设计范式。这一特点虽降低了部分灵活性，增加了BUG定位的复杂性，但减少了开发人员需要做出决定的数量，同时减少了大量的XML配置，并且可以将代码编译、测试和打包等工作自动化。 

### SpringBoot工程创建

#### 创建方式:

1.使用idea中的创建项目选项File-->New-->Project-->Spring Initializr-->自定义工程相关选项

-->选择SpringBoot版本和相关的依赖-->项目路径-->完成

2.[官网创建](https://start.spring.io)  具体使用详解官网和idea配置项类似.点击Generator按钮后会生成一个zip压缩文件,自动下载到本地.解压后导入开发工具即可.(建议使用idea)

#### 项目结构说明

1.目录说明(maven结构为例)

​	src

​	-----main

​		  -----java(源代码文件)

​				-----com.aaron(初始化指定包)

​					  -----Application.java(main方法启动类)			

​					  -----ServletInitializer.java(war的servlet初始化相关类)

​		  -----resource(资源文件)		

​				-----static(静态资源存放位置)

​				-----templates(模板存放位置)

​				-----application.properties(主配置文件)

​	-----test(测试相关)

​			 -----java

​			 -----com.aaron

​					  -----ApplicationTests.java

​	.gitignore(git提交忽略文件)

​	pom.xml(详解见下)

​	注意:已经删除初始化项目中用不到的文件.mvn,HELP.md.mvnw,mvnw.cmd文件(maven的一些适配包等文件)

2.SpringBoot会自动在指定的包下生成一个拥有main方法的启动类

```java
package com.aaron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBasicApplication.class, args);
    }

}
```

3.项目默认的主配置文件是.properties类型文件,推荐使用.yml类型文件.格式简单易懂.

4.pom文件详解

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <!--SpringBoot的父类依赖-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.14.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <!--项目描述-->
    <groupId>com.aaron</groupId>
    <artifactId>springboot-basic</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springboot-basic</name>
    <description>Demo project for Spring Boot</description>

    <!--项目的版本管理-->
    <properties>
        <java.version>1.8</java.version>
    </properties>

    <!--项目依赖,包括web依赖和test依赖
        SpringBoot的依赖包格式spring-boot-starter-xxx
    -->
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <!--maven插件-->
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>

```

5.SpringBoot项目内嵌了tomcat,不需要使用外部tomcat就可以直接运行.默认端口是8080,也可以使用外部的tomcat,打包方式变更为war方式,部署到外部web容器运行

6.打包方式,使用maven打包 mvn:package命令,会根据pom文件来生成jar/war包.

maven会先把项目代码进行打包:springboot-basic-0.0.1-SNAPSHOT.jar.original

pom中的maven插件会进行二次打包(repackage):springboot-basic-0.0.1-SNAPSHOT.jar 集成SpringBoot相关代码和依赖

7.项目启动.

​	7.1可以直接在idea中使用main方法进行启动

​	7.2可以把项目打成jar包,使用java -jar xxx.jar进行启动

8.启动日志

​	0.jdk的一些信息

​	1.banner图

​	2.开始启动,XxxApplication启动类执行

​	3.没有配置文件前缀,使用默认的

​	4.tomcat初始化,默认端口8080,启动tomcat引擎,tomcat版本9.xx

​	5.内嵌的WebApplicationContext容器启动(只有一个web容器,没有父子容器之分)

​	6.tomcat的一些信息打印,端口和访问路径

​	7.项目启动的耗时

#### 项目简单示例

1.新建子包com.aaron.controller

2.创建HelloController.java类

```java
package com.aaron.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String hello(){
        return "hello SpringBoot";
    }

}

```

3.启动项目.

idea中直接点击启动类即可

4.访问url:

localhost:8080/hello

### SpringBoot的war工程

创建项目时指定项目打包类型为war类型,

与jar包项目不同之处:

1.ServletInitializer.java(war包特有),Servlet初始化时使用

```java
package com.aaron;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringbootBasic1Application.class);
    }

}

```

2.pom文件( [maven--scope参考]( https://www.jianshu.com/p/7145f01ac3ad ) )

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.14.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <!--打包方式为war-->
    <groupId>com.aaron</groupId>
    <artifactId>springboot-basic1</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>war</packaging>
    <name>springboot-basic1</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!--指定tomcat的scope为provided
            provided:被依赖项目理论上可以参与编译、测试、运行等阶段，相当于compile，但是再打包阶段做了exclude的动作。
        -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>

```

3.项目运行

maven:package 打包成war包,到外部容器(tomcat)运行.

4.访问路径:localhost:8080/springboot-basic1-0.0.1-SNAPSHOT/hello

### SpringBoot的主配置文件

对于SpringBoot项目的主配置文件,名称必须为application.

SpringBoot项目的主配置文件默认是application.properties

```java
server.port=80
server.servlet.context-path=/springboot
```

推荐使用.yml格式 [yaml参考](  https://baike.baidu.com/item/YAML/1067697?fr=aladdin ) 

简单使用:#表示注释,空格为有效字符

```java
#修改tomcat端口,项目访问根路径
server:
  port: 80
  servlet:
    context-path: /springboot
```

修改配置文件以后,项目启动日志打印的端口和访问根路径都会发生改变.

### SpringBoot的Actuator监控器

Actuator是SpringBoot提供的可插拔的模块,用于对工程进行监控.通过不同的监控终端实现不同的监控功能.Spring Boot的Actuator可以部署在每个工程中.实现对每个工程的监控.

1.配置相关依赖

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.14.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.aaron</groupId>
    <artifactId>springboot-actuator</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springboot-actuator</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <!--actuator依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <!--增加resources相关配置,可以从pom文件中读取配置项-->
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <filtering>true</filtering>
            </resource>
        </resources>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <!--resource插件-->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-resources-plugin</artifactId>
                <version>2.6</version>
                <configuration>
                    <delimiters>
                        <delimiter>@</delimiter>
                    </delimiters>
                    <useDefaultDelimiters>false</useDefaultDelimiters>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>

```

2.Actuator相关配置项

```java
#内嵌tomcat相关属性配置
server:
  port: 8002
  servlet:
    context-path: /springboot-actuator
#actuator健康监控配置
management:
  server:
    port: 9001
    servlet:
      context-path: /actuator
  endpoints:
    web:
      base-path: /base #默认为 /actuator
      exposure:
        include: '*' #actuator默认开放的终端 health 和 info * 通配符需要用 单引号引起来使用 开放所有终端 [beans,env]
        exclude: [beans,mappings] #exclude 排除某些终端 表示不开启
#actuator添加info信息
#自定义info信息
info.author.name: Aaron
info.author.email: cao_shuai688@163.com
info.author.address: 上海

#读取pom.xml中的相应值 使用@符号读取
info.project.groupId: @project.groupId@
info.project.artifactId: @project.artifactId@
info.project.version: @project.version@
info.project.packaging: @project.packaging@
```

3.访问路径:localhost:9001/actuator/base/xxx(xxx表示监控终端的路径)

4.常用监控终端

  在百度搜索“springboot actuator”即可找到如下表格  

![1589813986338](C:\Users\semon\AppData\Roaming\Typora\typora-user-images\1589813986338.png)

5.**自定义实现SpringBoot监控的可视化监控**



## SpringBoot重要用法

### 自定义异常页面

### 单元测试

### 多环境选择

### 读取自定义配置

### SpringBoot集成Mybatis

### SpringBoot事务支持

### SpringBoot集成Redis

### SpringBoot日志控制

### SpringBoot集成Dubbo

### SpringBoot集成JSP

### SpringBoot中拦截器应用

### SpringBoot中Servlet应用

### SpringBoot中Filter应用









