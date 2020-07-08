package com.yume.yume;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.yume.yume.mapper")
@EnableScheduling
public class YumeApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(YumeApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(YumeApplication.class);
    }


    public static String _UUID = "442426299";
    public static boolean isEnableSwagger = true;
}
