package com.test.springwservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class WelcomeController {
	@GetMapping("/show")
	public String getMessage()
	{
		return "welcome";
	}

}
