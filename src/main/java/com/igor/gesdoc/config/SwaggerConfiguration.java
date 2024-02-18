package com.igor.gesdoc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration // pour indiquer qu'il s'agit d'une classe de configuration
//@EnableSwagger2 // pour utiliser la documentation Swagger
//public class SwaggerConfiguration {
//
//    @Bean // indiquer à spring que cet élément doit être chargé lors du démarrage de l'application
//    public Docket madocumentation(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(new ApiInfoBuilder()
//                        .title("Gestion de documents API REST")
//                        .description("Documentation de l'API pour la gestion de documents")
//                        .license("bik")
//                        .version("1.0")
//                        .build()
//                )
//                .groupName("API REST V1.0")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.igor.gesdoc"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//}
