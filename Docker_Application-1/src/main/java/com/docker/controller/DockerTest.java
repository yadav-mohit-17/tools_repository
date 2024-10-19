package com.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerTest {

	@GetMapping("/hello")
	public String getData() {
		return "Welcome Docker User";
	}
}
