package com.fpi.test;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fpi.test.mapper")
@NacosPropertySource(dataId = "test",groupId = "mytest",autoRefreshed = true)
public class Application {

    public static void main(String[] args) {
      SpringApplication.run(Application.class,args);
    }
}
