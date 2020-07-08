package com.yume.yume.config;

import com.yume.yume.YumeApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(){

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .enable(YumeApplication.isEnableSwagger)
                .select().apis(RequestHandlerSelectors.basePackage("com.yume.yume.controller")).build();
    }

    //配置apiinfo
    private ApiInfo apiInfo(){
        Contact contact = new Contact("李天宇","http://nas.ltyearth.cn:5000","985094108@qq.com");
        return new ApiInfo("琴吹梦の避难所-后端API文档",
                "琴吹梦の避难所-后端API文档",
                "v0.1",
                "http://www.google.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",new ArrayList());
    }
}
