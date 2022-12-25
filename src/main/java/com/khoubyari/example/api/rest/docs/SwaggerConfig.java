package com.khoubyari.example.api.rest.docs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@ComponentScan("com.khoubyari.example.api.rest")
public class SwaggerConfig {

//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                        .apis(RequestHandlerSelectors.any())
//                .paths(Predicates.not(PathSelectors.regex("/error")))
//                .build()
//                .apiInfo(apiInfo());
//    }
    

    private ApiInfo apiInfo() {
        String description = "REST example";
        return new ApiInfoBuilder()
                .title("REST example")
                .description(description)
                .termsOfServiceUrl("github")
                .license("Siamak")
                .licenseUrl("")
                .version("1.0")
 //               .contact(new Contact("siamak"))
                .build();
    }

}
