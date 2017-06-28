package com.jia16.uc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by lazyb on 2017/6/22.
 */
@SpringBootApplication
@ComponentScan
@MapperScan(value = "com.jia16.uc.mapper")
@ImportResource("classpath*:/dubbo/dubbo-config.xml")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
