## Spring Boot & Cloud

### 什么是微服务

![](doc/img/s01.png)

![](doc/img/s02.png)

![](doc/img/s03.png)

### spring boot 提供了两种类型的配置文件形式
> 1.properties文件形式。

> 2.yml文件形式(推荐)。


### boot jar包结构
![](doc/img/s04.png)


### @Value 获取配置文件里面的配置信息
> @Value("${myConfig.myObject.myName}")


### 获取环境变量信息org.springframework.core.env.Environment

```
org.springframework.core.env.Environment

@Configuration
   public class AppConfig {

       @Autowired Environment env;

       @Bean
       public MyBean myBean() {
           MyBean myBean = new MyBean();
           myBean.setName(env.getProperty("bean.name"));
           return myBean;
       }
   }

Environment还可以使用@PropertySource里面的东西

@Configuration
   @PropertySource("classpath:/com/acme/app.properties")
   public class AppConfig {

       @Inject Environment env;

       @Bean
       public MyBean myBean() {
           return new MyBean(env.getProperty("bean.name"));
       }
   }

@Value可以使用@PropertySource里面的东西

@Configuration
   @PropertySource("classpath:/com/acme/app.properties")
   public class AppConfig {

       @Value("${bean.name}") String beanName;

       @Bean
       public MyBean myBean() {
           return new MyBean(beanName);
       }
   }



```

### @Import导入配置，组合配置

```
@Configuration
   public class DatabaseConfig {

       @Bean
       public DataSource dataSource() {
           // instantiate, configure and return DataSource
       }
   }

   @Configuration
   @Import(DatabaseConfig.class)
   public class AppConfig {

       private final DatabaseConfig dataConfig;

       public AppConfig(DatabaseConfig dataConfig) {
           this.dataConfig = dataConfig;
       }

       @Bean
       public MyBean myBean() {
           // reference the dataSource() bean method
           return new MyBean(dataConfig.dataSource());
       }
   }
```

### @Profile 指定激活哪个环境的配置文件，如果使用了Apollo这个东西就没用了

```
@Profile("development")
   @Configuration
   public class EmbeddedDatabaseConfig {

       @Bean
       public DataSource dataSource() {
           // instantiate, configure and return embedded DataSource
       }
   }

   @Profile("production")
   @Configuration
   public class ProductionDatabaseConfig {

       @Bean
       public DataSource dataSource() {
           // instantiate, configure and return production DataSource
       }
   }


或者


@Configuration
   public class ProfileDatabaseConfig {

       @Bean("dataSource")
       @Profile("development")
       public DataSource embeddedDatabase() { ... }

       @Bean("dataSource")
       @Profile("production")
       public DataSource productionDatabase() { ... }
   }

```

### @SpringBootApplication 注解包含：@SpringBootConfiguration，@EnableAutoConfiguration，@ComponentScan 三个注解。



### @EnableAutoConfiguration
> Enable auto-configuration of the Spring Application Context, attempting to guess and configure beans that you are likely to need. Auto-configuration classes are usually applied based on your classpath and what beans you have defined.

> You can always manually exclude() any configuration that you never want to apply (use excludeName() if you don't have access to them). You can also exclude them via the spring.autoconfigure.exclude property.

>  It is generally recommended that you place @EnableAutoConfiguration (if you're not using @SpringBootApplication) in a root package so that all sub-packages and classes can be searched.

















