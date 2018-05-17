package com.springboot;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component//通过此种方式无法将这个初始化器装配到Spring容器中
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("Spring容器初始化的Bean的个数:" + applicationContext.getBeanDefinitionCount());
	}

}
