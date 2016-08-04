package com.globant.ms.god.workstationPositions._config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.globant.ms.god.domain.WorkstationPosition;
import com.globant.ms.god.workstationPositions.repository.IWorkstationPositionRepository;

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
	public CommandLineRunner initializeGlobers(IWorkstationPositionRepository workstationPositionRepository) {
		return args -> {
			Arrays.asList("1:1:1:15:1101,2:2:2:16:1102,3:3:3:15:1103".split(",")).forEach(str -> {

				String[] data = str.split(":");

				WorkstationPosition workstationPosition = WorkstationPosition.builder().id(Long.valueOf(data[0]))
						.idGlober(Long.valueOf(data[1])).idWorkstation(Long.valueOf(data[2])).floor(data[3])
						.deskNumber(Integer.valueOf(data[4])).build();

				workstationPositionRepository.save(workstationPosition);

				log.info("saving workstationPosition: {}", workstationPosition);
			});
		};
	}
}

/*@Configuration
class RepositoryConfig extends RepositoryRestMvcConfiguration {

	@Override
	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(WorkstationPosition.class, Workstation.class);
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
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfoBuilder().title("Globers Microservice - Spring Cloud Netflix")
				.description("API REST documentation about Globers Microservice").contact("Globant Talent Pool")
				.build();
		return apiInfo;
	}
}