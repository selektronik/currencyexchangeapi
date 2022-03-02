package com.example.currencyexchangeapi.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022 10:42 PM
 * @Version 1.0
 */
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.currencyexchangerate"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Exchange Currency Api - Spring Boot Swagger Configuration")
            .description("Exchange Currency Api  API reference for developers")
            .version("1.0.0")
            .license("Apache 2.0").build();
    }


}
