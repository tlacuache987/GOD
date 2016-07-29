package com.globant.ms.god.globers._config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.globant.ms.god.globers.domain.Glober;
import com.globant.ms.god.globers.domain.WorkStationPosition;
import com.globant.ms.god.globers.repository.IGloberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class InitializeAppConfig {

	@Bean
	public CommandLineRunner initializeGlobers(IGloberRepository globerRepository) {
		return args -> {
			Arrays.asList(
					"1:Ivan:15:101:workstation-1,2:Carlos:15:102:workstation-2,3:Laura:15:103:workstation-3".split(","))
					.forEach(str -> {

				String[] data = str.split(":");

				WorkStationPosition workstation = WorkStationPosition.builder().floor(data[2])
						.deskNumber(Integer.valueOf(data[3])).workStation(data[4]).build();

				Glober glober = Glober.builder().id(Long.valueOf(data[0])).name(data[1]).workstation(workstation)
						.build();

				globerRepository.save(glober);

				log.info("saving glober: {}", glober);
			});
		};
	}
}
