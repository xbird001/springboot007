package com.springboot;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value=2)
@Component
public class MyCommandLineRunner2 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("当前时间：" + LocalDate.now().toString());
	}

}
