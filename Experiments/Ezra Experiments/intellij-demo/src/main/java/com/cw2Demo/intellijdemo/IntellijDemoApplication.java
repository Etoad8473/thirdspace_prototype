package com.cw2Demo.intellijdemo;

import com.cw2Demo.intellijdemo.configuration.AppConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.w3c.dom.ls.LSOutput;

@SpringBootApplication
public class IntellijDemoApplication {

	private static Logger log = LoggerFactory.getLogger(IntellijDemoApplication.class);

	public static void main(String[] args)
	{
		ConfigurableApplicationContext context = SpringApplication.run(IntellijDemoApplication.class, args);
		System.out.println("Hello world!");

		AppConfiguration appConfiguration = context.getBean(AppConfiguration.class);
		log.info(appConfiguration.getServerPort());
		log.info(appConfiguration.getIntegrationServiceUrl());
	}
}
