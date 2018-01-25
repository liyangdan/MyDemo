package com.chen;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;

/**
 * Created by liyangdan on 2018/1/24.
 */
@EnableSwagger2
public class SwaggerConfiguration {

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
//        return new ApiInfo(
//                "mylearn 前后端接口-外部", // title 标题
//                "外部接口文档", // description 描述 标题下
//                "1.0.0", // version
//                "http://mylearn/*", // termsOfService
//                new Contact("xieyuebin", "", "xieyuebin@meituan.com"), // contact
//                "Apache 2.0", // licence
//                "http://www.apache.org/licenses/LICENSE-2.0.html" // licence url
//        );

    }

//    @Bean
//    public UiConfiguration getUiConfig() {
//        return new UiConfiguration(
//                null,// url,暂不用
//                "none",       // docExpansion          => none | list
//                "alpha",      // apiSorter             => alpha
//                "schema",     // defaultModelRendering => schema
//                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
//                false,        // enableJsonEditor      => true | false
//                true);        // showRequestHeaders    => true | false
//    }
}