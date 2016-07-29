package com.globant.ms.god.globers.ws.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/v1")
public class GlobersLolController2 {

	@Value("${lol}")
	private String lolString;

	@RequestMapping(value = "/lol2", method = RequestMethod.GET)
	public String getLolString() {
		return lolString + " " + lolString;
	}
}
