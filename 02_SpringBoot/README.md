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

# HTTP 接口
* 参照Class GetController
    * 基本的HTTP接口中GET和POST方法
* 参照Class OtherHttpController
    * HTTP接口中GET POST DEL PUT请求

# Json 接口
* 参照 /com/emon/springboot02/domain/user.java中，关于Json相关的注解
    * @JsonInclude(Include.NON_NULL) → 空值不返回到前端
    * @JsonIgnore                    → 不返回该字段到前端
    * @JsonProperty("ACCUNT")        → 给该字段起别名
    * @JsonFormat(pattern = "yyyy-mm-dd", locale = "zh", timezone = "GMT+8") → 格式化该字段

# SpringBoot目录文件结构讲解
* 目录结构
    * src/main/java: 存放代码
    * src/main/resources: 存放静态资源文件
        * Static: 存放静态文件，例如 css js image等，访问格式为 http://localhost:8080/js/main.js
        * Templates: 存放静态页面，例如jsp html tpl等
        * Config: 存放配置文件 application.properties
        * Resources: 例如脚本等
* 同个文件的加载顺序(静态资源文件)
    * 顺序: META/resource > resources > static > public
    * SpringBoot会按照上述顺序寻找有无相应的资源，有的话则直接返回
    * 测试：
        * 在对应的resource文件夹中放入同名文件test.js
        * test.js的内容为输出文件夹名称
        * 启动程序
        * 访问 http://localhost:8080/test.js
        * 然后按照顺序删除文件夹中的test.js文件，会发现输出的内容不同
* 访问html资源
    * 首先将index.html放到静态资源路径下 \src\main\resources\templates
    * 在pom文件中导入访问静态资源需要的依赖 spring-boot-starter-thymeleaf
    ```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
    ```
    * 创建controller，REF /com/emon/springboot02/domain/FileController.java index() 方法
    * 还可以将index.html放置于public resource static中，这些文件夹可以直接被读取静态资源，所以不再需要添加依赖和controller (spring.resources.static-locations中)
* 静态资源配置文件
    * 复写application.propertites (在/src/main/resources路径下新建或修改)
    * 在其中加入spring.resources.static-locations = classpath:/META-INF-resources/,classpath:/resources/,...在后面加上我们所指定的路径

# 文件上传
* REF /com/emon/springboot02/domain/FileController

# 常见问题
## 导入或新建项目工程后发现有报错
* 右键工程选择maven-update project，让项目重新下载依赖即可
* 也要确认是不是缺少依赖项

## 端口占用的问题
* 首先找到占用8080端口的进程
    * `netstat -ano` 找端口8080的记录，记录下后面的PID
    * `tasklist | findstr "PID"` 找到PID对应的进程名(第一项 例如 javaw.exe)
    * `taskkill /f /t /im 进程名` 杀进程 `taskkill /f /t /im javaw.exe`