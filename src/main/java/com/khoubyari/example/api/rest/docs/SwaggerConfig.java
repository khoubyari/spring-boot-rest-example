package com.khoubyari.example.api.rest.docs;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.wordnik.swagger.model.ApiInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by skhoubyari on 7/30/14.
 */
@Configuration
@EnableSwagger
@ComponentScan("com.khoubyari.example.api.rest")
public class SwaggerConfig {

    //public static final List<String> DEFAULT_INCLUDE_PATTERNS = Arrays.asList("/xservice/.*");
    public static final String DEFAULT_INCLUDE_PATTERNS = "/example/.*";

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean //Don't forget the @Bean annotation
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo())
                .includePatterns(DEFAULT_INCLUDE_PATTERNS);
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot Sample REST APIs",
                "The APIs here demonstrate creating a 'production-ready' service built with Spring Boot and other helpful libraries",
                "http://opensource.org/licenses/MIT",
                "khoubyari@gmail.com",
                "MIT",
                "http://opensource.org/licenses/MIT"
        );
        return apiInfo;
    }
}
