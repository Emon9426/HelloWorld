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
    * 在其中加入spring.resources.static-locations = classpath:/META-INF/resources/,classpath:/resources/,...在后面加上我们所指定的路径

# 文件上传
* REF /com/emon/springboot02/domain/FileController
* 修改文件大小限制
    * 设置代码
    ```
    @Bean
	public MultipartConfigElement multipartConfig() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 单个文件的最大size
		factory.setMaxFileSize("10240KB");
		// 总上传数据总大小
		factory.setMaxRequestSize("1024000KB");
		
		return factory.createMultipartConfig();
	}
    ```
    * 需要将代码放置于有configuration注解的类中
    * 在当前工程中，启动类带有@SpringBootApplication注解，其中包括了@SpringBootConfiguration和@EnableAutoConfiguration
    * 所以可以放置于启动类中

# 打jar包
* 添加Maven依赖
    ```
        <build>
            <plugins>
                <plugin>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-maven-plugin</artifactId>
                <plugin/>
            <plugins/>
        </build>
    ```
    * 不添加时报错: no main manifest attribute, in XXX.jar
* 运行 Maven install
    * 程序会被打包到 xxx\spring-boot-02\target 下
    * 使用
      ``` 

# 热部署
* 使用插件devtools进行热部署
* 添加依赖
    * 在pom文件中添加依赖
    ```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>sping-boot-devtools</artifactId>
        <optional>true</optional>
    </dependency>
    ```
    * 添加依赖后重启项目
* 修改Controller后，会将class自动加载到jvm中。
* 工程会自动重启，只会编译修改的文件。
* 不会触发热部署重启的情况
    * 静态资源不会被监听修改
    * 在application.properties中配置：
        * spring.devtools.restart.exclude=static/\*\*,public/\*\*,application.properties
* 热部署重启开关
    * 在resources中新建一个trigger.txt作为热部署文件开关
    * 在application.properties中配置：
        * spring.devtools.restart.trigger-file=trigger.txt
    * 当trigger.txt被修改时，才会进行热部署，否则不会进行热部署

# 配置文件
* 常用的配置文件
    * YAML: 采用树状结构，key后面需要为 冒号+空格
        * 示例：
        ```
        application.yml
        server: 
            port: 8090
            session-timeout: 30
        ```
    * Properites: 采用等号的方式
        * 示例：
        ```
        application.properties
        server.port=8080
        server.session-timeout=30
* 配置文件的加载顺序
    * /config → 当前目录 → classpath /config package → classpath root
    * 可以根据路径顺序对config文件进行复写
* Springboot默认配置
    * https://docs.spring.io/spring-boot/docs/2.x.x.xxx/reference/htmlsingle/#common-application-properties
    * 不需要复制到配置文件中，只需要修改需要的属性即可
* 注入配置文件 ref: FileController.java
    * 在Controller上添加 @@PropertySource({"classpath:配置文件"})
    * 在字段上使用 @value("${属性名}")
* 实体类的配置
    * 首先创建实体类 ref ServerSetting.java
        * 实体类需要包括三个注解
        ```
        @Component
        @PropertySource({"classpath:application.properties"})
        @ConfigurationProperties或@ConfigurationProperties(prefix="test")
        ```
        * 使用@ConfigurationProperties时，属性类中属性值使用@value("${前缀.属性名}")的方式注入
        * 使用@ConfigurationProperties(prefix="test")时，属性类中属性值使用@value("属性名")的方式注入
    * 其次修改controller ref GetController.testProperties()
        * 使用 @Autowired 进行注入
    * Spring框架会从声明@ComponentScan所在的类的Package开始扫描，扫描同级目录和子目录
        * @ComponentScan在Main方法所在的启动类中包含
        * 所以要求启动类处于根目录包或和其他包同级的目录下


# 常见问题
## 导入或新建项目工程后发现有报错
* 右键工程选择maven-update project，让项目重新下载依赖即可
* 也要确认是不是缺少依赖项

## 端口占用的问题
* 首先找到占用8080端口的进程
    * `netstat -ano` 找端口8080的记录，记录下后面的PID
    * `tasklist | findstr "PID"` 找到PID对应的进程名(第一项 例如 javaw.exe)
    * `taskkill /f /t /im 进程名` 杀进程 `taskkill /f /t /im javaw.exe`