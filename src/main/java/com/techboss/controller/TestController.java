package com.techboss.controller;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MetricsEndpoint metricsEndpoint;
	
	@GetMapping
	public String generateLogs() {
		metricsEndpoint.listNames().getNames().forEach(n -> {
			 logger.info(n + " = " + metricsEndpoint.metric(n, Collections.emptyList()).getMeasurements());
		});
		return "Generated";
	}

}
