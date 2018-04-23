package com.marykay.country.love.api.controller.external;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@RestController
public class HealthyTestController {

	@ApiIgnore
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String healthCheck() {
		return "health true";
	}
}
