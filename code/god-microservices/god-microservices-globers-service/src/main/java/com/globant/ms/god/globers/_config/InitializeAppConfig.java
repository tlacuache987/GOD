package com.globant.ms.god.globers._config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.globant.ms.god.domain.Glober;
import com.globant.ms.god.globers.repository.IGloberRepository;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@Configuration
public class InitializeAppConfig {

	@Bean
	public CommandLineRunner initializeGlobers(IGloberRepository globerRepository) {
		return args -> {
			Arrays.asList("1:Ivan,2:Carlos,3:Laura".split(",")).forEach(str -> {

				String[] data = str.split(":");

				Glober glober = Glober.builder().id(Long.valueOf(data[0])).name(data[1]).build();

				globerRepository.save(glober);

				log.info("saving glober: {}", glober);
			});
		};
	}
}

/*@Configuration
class RepositoryConfig extends RepositoryRestMvcConfiguration {

	@Override
	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Glober.class);
		// config.setDefaultMediaType(MediaType.APPLICATION_JSON);
	}
}*/

@Configuration
@EnableSwagger2
class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(this.apiInfo()).select()
				.paths(PathSelectors.regex("/v1.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Globers Microservice - Spring Cloud Netflix")
				.description("API REST documentation about Globers Microservice").contact("Globant Talent Pool")
				.build();
	}
}