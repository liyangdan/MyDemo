package com.chen;


import com.google.common.base.Predicate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;


@ServletComponentScan
@SpringBootApplication
@MapperScan("com.chen.mapper")
@EnableSwagger2 //启用swagger
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket getApiInfo() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Test文档")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(financePaths())//指定路径处理PathSelectors.any()代表所有的
                .build()
                .apiInfo(outApiInfo());

    }
    //    @SuppressWarnings("unchecked")
    private Predicate<String> financePaths() {
        return or(PathSelectors.regex("/user.*"));//这里是正则表达式
    }

    private ApiInfo outApiInfo() {
        return new ApiInfoBuilder().title("使用Spring Boot 集成 swagger")
                .description("Zcy数据库增、删、查、改").build();

    }
}
