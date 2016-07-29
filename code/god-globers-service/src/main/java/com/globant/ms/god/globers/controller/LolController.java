package com.globant.ms.god.globers.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class LolController {

	@Value("${lol}")
	private String lolString;

	@RequestMapping(value = "/lol", method = RequestMethod.GET)
	public String getLolString() {
		return lolString;
	}
}
