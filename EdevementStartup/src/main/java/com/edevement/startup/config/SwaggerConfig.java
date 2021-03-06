package com.edevement.startup.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/addUser.*"), regex("/user-search.*"), regex("/fetch-all-users.*"), regex("/fetch-questions-by-type-category.*"),
				regex("/submit-quiz.*"),regex("/user-update.*"), regex("/fetch-quiz-types.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("EdevementStartup API")
				.description("EdevementStartup API reference for developers")
				.termsOfServiceUrl("http://javainuse.com")
				.contact("shoubhik.ghosh09@gmail.com").license("JavaInUse License")
				.licenseUrl("shoubhik.ghosh09@gmail.com").version("1.0").build();
	}

}