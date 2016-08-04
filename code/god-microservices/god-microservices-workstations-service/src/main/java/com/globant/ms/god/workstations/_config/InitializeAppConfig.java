package com.globant.ms.god.workstations._config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.globant.ms.god.domain.Workstation;
import com.globant.ms.god.workstations.repository.IWorkstationRepository;

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
	public CommandLineRunner initializeGlobers(IWorkstationRepository workstationRepository) {
		return args -> {
			Arrays.asList(
					"1:DELL:desktop-workstation-xyz:123123,2:DELL:laptop-workstation-abc:234234,3:DELL:laptop-workstation-abc:345345"
							.split(","))
					.forEach(str -> {

				String[] data = str.split(":");

				Workstation workstation = Workstation.builder().id(Long.valueOf(data[0])).vendor(data[1]).model(data[2])
						.facilitiesSerialNumber(data[3]).build();

				workstationRepository.save(workstation);

				log.info("saving workstation: {}", workstation);
			});
		};
	}
}

/*@Configuration
class RepositoryConfig extends RepositoryRestMvcConfiguration {

	@Override
	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Workstation.class);
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