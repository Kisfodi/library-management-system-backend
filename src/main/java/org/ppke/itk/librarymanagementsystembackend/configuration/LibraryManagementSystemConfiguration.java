package org.ppke.itk.librarymanagementsystembackend.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.SimpleDateFormat;

@Configuration
public class LibraryManagementSystemConfiguration {

    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        return new Jackson2ObjectMapperBuilder().dateFormat(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"));
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Library Management System")
                                .version("0.0.1-SNAPSHOT")
                                .description("Library Management System")
                                .termsOfService("http://swagger.io/terms/")
                                .license(new License().name("Apache 2.0").url("http://springdoc.org"))

                );
    }



}
