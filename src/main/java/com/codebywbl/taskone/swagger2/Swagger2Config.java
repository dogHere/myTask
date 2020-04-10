package com.codebywbl.taskone.swagger2;/*
    @author:bl
    @date:2020/04/09 20:06
    @description:
*/


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2   //开启swagger2
public class Swagger2Config {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.codebywbl.taskone.controller"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo getApiInfo() {
        Contact contact = new Contact("wbl","http://127.0.0.1","wangbinglie131@126.com");
        return new ApiInfoBuilder().title("标题:员工管理").description("项目网址:http://127.0.0.1")
                .version("版本：第二版").contact(contact).build();
    }
}
