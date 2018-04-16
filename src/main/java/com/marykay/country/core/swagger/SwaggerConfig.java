package com.marykay.country.core.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangliu on 2018/4/8.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${SwaggerEnable}")
	private boolean swaggerEnable;

	@Bean
	public Docket externalApi() {
//		List<Parameter> params = new ArrayList<Parameter>();
//		params.add(new Parameter("Authorization", "", "Bearer {access_token}", true, false, new ModelRef("String"), null, null, "header", null, false, null));
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())//调用apiInfo方法,创建一个ApiInfo实例,里面是展示在文档页面信息内容
				.enable(swaggerEnable)
				.groupName("external")
//				.globalOperationParameters(params)
				.select()
				//@ApiIgnore ,the interface will not expose on swagger2 page
				.apis(RequestHandlerSelectors.basePackage("com.marykay.country.love.api.controller.external"))
				.paths(PathSelectors.any())
				.build();
	}

	//api document detail infromation
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				//title
				.title("Country-Love-Api")
				//verson
				.version("1.0")
				//description
				.description("API description")
				.build();
	}

}
