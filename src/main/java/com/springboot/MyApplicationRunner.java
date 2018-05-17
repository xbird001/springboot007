package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {

	@Autowired
	private Environment env;
	@Autowired
	private ConfigurableApplicationContext cac;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("----------ApplicationRunner参数解析--------------");
		System.out.println("server.port:" + env.getProperty("server.port"));
		System.out.println("ConfigurableApplicationContext.server.port:" + cac.getEnvironment().getProperty("server.port"));
		System.out.println(args.getOptionNames());
		for(String optionName : args.getOptionNames()) {
			System.out.println(optionName + ":" + args.getOptionValues(optionName));
		}
	}

}
