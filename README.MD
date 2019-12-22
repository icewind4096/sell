# SpringBoot 

## Step 1 (坑点)  
1. config-location用于设置mybatis配置文件的路径, 配置文件中，可以配置Mapper文件位置，以及MyBatis的其他基础配置
2. mapper-locations用于配置xxxmap.xml文件位置
   ```
   mapper-locations: classpath:mappers/*.xml
   此处设置map文件扫描路径位于classpath\mappers\  
   ```
   如果非要配置map文件在src目录中，请在pom.xml中做如下修改, 否则项目打包时，无法加入scr目录中的mapper文件
   ```
    <build>
        <resources>
            <!-- 如果不加，那么打包的时候非JAVA文件不会被打包进来 -->
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
        </resources>
    </build>    
   ```
3. 在Mapper类中，如果不希望出现红字（并不影响运行），加上@Repository注解，@Mapper注解必须存在
    1). @Repository是Spring的注解, 需要在Spring中配置扫描地址，然后生成Dao层的Bean才能被注入到Service层中。  
    2). @Mapper是MyBatis的注解,不需要配置扫描地址，通过xml里面的namespace里面的接口地址，生成了Bean后注入到Service层中。  
    3). 如果@Repository和@Mapper都不想写，请在启动类上加入@MapperScan, 将会自动扫描路径下的所有接口
4. 实体类如果有自定义构造方法，必须收工写一个无参构造方法  

## Step 2 (日志篇)
1. 配置方式  
    a.) 在application.yml中进行配置
    ```
        logging:
          pattern:
            console: "%d -%smg%n" //配置控制台输出格式
          file:
            path: src\main\resources\log  //配置到scr\main\resources\log目录下
            name: src\main\resources\log\sell.log //配置到scr\main\resources\log目录下, 文件名为sell.log
            path与name只可以二选一
          level: debug //配置log输出级别, 还可以指定特定类的输出级别  
    ```
    b.) 使用logback-spring.xml文件方式进行配置   
        i.) 首先在application.yml中进行配置  
     ```
        logging:
          config: classpath:logback-spring.xml
     ```
        ii.) 其次在logback-spring.xml配置具体模式
     ```
        <configuration>
            <appender name="consolelog" class="ch.qos.logback.core.ConsoleAppender">
                <layout class="ch.qos.logback.classic.PatternLayout">
                    <pattern>
                        %d - %msg%n
                    </pattern>
                </layout>
            </appender>         //此处定义控制台输出配置
        
            <appender name="fileInfoLog" class="ch.qos.logback.core.rolling.RollingFileAppender">
                <filter class="ch.qos.logback.classic.filter.LevelFilter">
                    <level>ERROR</level>        \\如果LEVEL等于ERROR
                    <onMatch>DENY</onMatch>     \\如果匹配ERROR 就拒绝
                    <onMismatch>ACCEPT</onMismatch> \\如果不匹配ERROR 就接受
                </filter>
                <encoder>
                    <pattern>
                        %msg%n
                    </pattern>
                </encoder>
                <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                    <fileNamePattern>
                        src\main\resources\log\info.%d.log  //按照时间每天输出一个文件
                    </fileNamePattern>
                </rollingPolicy>
            </appender>     //此处定义文件输出配置 
        
            <appender name="fileErrLog" class="ch.qos.logback.core.rolling.RollingFileAppender">
                <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
                    <level>ERROR</level>            \\只输出LEVEL等于ERROR 只有ERROR可以这样配置，因为等级最高，否则使用上面的配置进行过滤
                </filter>
                <encoder>
                    <pattern>
                        %msg%n
                    </pattern>
                </encoder>
                <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                    <fileNamePattern>
                        src\main\resources\log\err.%d.log
                    </fileNamePattern>
                </rollingPolicy>
            </appender>
        
            <root level="info">
                <appender-ref ref="consolelog" />       
                <appender-ref ref="fileInfoLog" />
                <appender-ref ref="fileErrLog" />
            </root> //应用配置, 只针对LEVEL等于info的, 其他的配置参考以上
        </configuration>
    ```