/*
  Created by IntelliJ IDEA.
  User: Long
  Date: 2018/10/18
  Time: 21:28
  To change this template use File | Settings | File Templates.
*/
package org.mml.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//api显示注解官网http://docs.swagger.io/swagger-core/apidocs/com/wordnik/swagger/annotations/package-summary.html
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //// 指定controller存放的目录路径
                .apis(RequestHandlerSelectors.basePackage("org.mml.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：https://github.com/Yuicon/blog/issues/1")
                .termsOfServiceUrl("https://github.com/Yuicon/blog/issues/1")
                .contact("menglong")
                .version("1.0")
                .build();
    }

}