package com.globant.ms.god.zuul.consumer.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String sentence() {
		return "index";
	}
}
