package com.springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Component
public class MyCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CommandLineRunner参数：" + Arrays.asList(args));
	}

}
