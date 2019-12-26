# 手动创建spring boot应用 - spring-boot-01
* 新建Maven项目，勾选simple project 
* 输入group id和Artifact id即可点击Finish   
* STS会自动生成文件结构 
* 修改pom文件，添加依赖
    * 新建依赖如下：
    ```
    <dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		
		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
	</dependencies>
    ```
    * 可以使用旧有项目的依赖，或使用自动生成器生成(自动生成应用时的网址)
* 新建controller
    * 在/src/main/java中添加controller
        * 其中要有`@RequestMapping("/")`和`@ResponseBody`，否则会好不到网页
        * _这两个同义词需要先添加spring-boot-starter-web依赖在pom文件中_
        * 需要在controller中添加主方法
* 有键controller文件，选择run as spring app
* 打开浏览器访问[localhost:8080](http://localhost:8080)

# 自动创建spring boot应用 - spring-boot-02
* 使用Spring官网生成项目框架
    * 生成器链接[https://start.spring.io/](https://start.spring.io/)
    * 填写页面信息
        * 在Dependences中要添加web
    * 点击 Generate 将自动生成的项目框架下载到本地并解压
* 导入项目框架
    * import-maven-exists maven project
* 添加Controller
    * 由于在 class SpringBoot02Application 中已经有Main方法，所以在controller中仅仅指定返回值即可

# HTTP GET
* 参照Class GetController
    * 使用 restful协议，从路径中获取字段：
        * REF: public Object findUser()
    * 使用 GetMapping 注解
        * REF: public Object pageUser
    * 使用 GetMapping 注解 包含默认值或必填项
        * public Object pageUser2

# 常见问题
## 导入或新建项目工程后发现有报错
* 右键工程选择maven-update project，让项目重新下载依赖即可
* 也要确认是不是缺少依赖项

## 端口占用的问题
* 首先找到占用8080端口的进程
    * `netstat -ano` 找端口8080的记录，记录下后面的PID
    * `tasklist | findstr "PID"` 找到PID对应的进程名(第一项 例如 javaw.exe)
    * `taskkill /f /t /im 进程名` 杀进程