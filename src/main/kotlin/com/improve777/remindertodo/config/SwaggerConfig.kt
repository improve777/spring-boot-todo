package com.improve777.remindertodo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.hateoas.client.LinkDiscoverer
import org.springframework.hateoas.client.LinkDiscoverers
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer
import org.springframework.plugin.core.SimplePluginRegistry
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger.web.UiConfiguration
import springfox.documentation.swagger.web.UiConfigurationBuilder
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .apiInfo(metadata())
    }

    private fun metadata(): ApiInfo {
        return ApiInfoBuilder()
            .title("test swagger docs")
            .description("test")
            .version("1.0")
            .build()
    }

    @Bean
    fun uiConfig(): UiConfiguration =
        UiConfigurationBuilder.builder()
            .build()

    // swagger 와 hateoas 충돌 문제 해결을 위해 등록
    @Bean
    fun discovereres(): LinkDiscoverers {
        return LinkDiscoverers(
            SimplePluginRegistry.create(
                listOf<LinkDiscoverer>(
                    CollectionJsonLinkDiscoverer()
                )
            )
        )
    }
}
