package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import com.springcore.bean.User;

/**
 * 
 * Springboot扩展点分析：
 * 	1、ApplicationContextInitializer接口实现类：Spring容器执行refreshed方法前的回调，此时Spring容器还未初始化好
 * 		1.1、自定义ApplicationContextInitializer接口实现类
 * 		1.2、装配ApplicationContextInitializer接口实现类到Spring容器中
 * 			 装配的方式：(注意通过注解@Componet无法装配到Spring容器中)
 * 			1.2.1、app.addInitializers(new MyApplicationContextInitializer());
 * 			1.2.2、通过默认配置文件中配置：context.initializer.classes配置全类名，支持配置多个，多个通过逗号隔开，具体参见本项目application.properties
 * 			1.2.3、通过spring.factories文件配置的方式，该文件可以是第三方的项目或jar，也可以是当前项目，此种方式一般是用作第三方，
 * 					进行不动声色的管理第三方的Bean，具体参见项目beanService中的META-INF/spring.factories中的#applicationContextInitializer
 * 	2、CommandLineRunner接口的实现类是Spring容器初始化完成后的回调，定义该接口的实现类，可以简单的认为就是要调用此类，可以配置多个CommandLineRunner
 * 		接口的实现类，这些实现类可以通过注解@Order进行排序
 * 	3、ApplicationRunner接口的实现类与CommandLineRunner接口的实现类的作用一样，只是对原始的启动参数做了封装 --foo=bar --debug
 * 		CommandLineRunner中的run方法是启动时的原始参数
 * 		ApplicationRunner中的run方法是对启动时的原始参数做了封装
 */
@EnableAutoConfiguration
@ComponentScan
public class App {
	
	public static void main(String[] args) {
		/**
		 * SpringApplication.run(Object source, String... args);的run方法默认把source包装成一个Configuration注解过的类，即调用
		 * 此方法时，完全可以不用在对应的类上面添加任何注解，所以此时我们可以在任何source类中添加@bean注解，并获取对象
		 */
		SpringApplication app = new SpringApplication(App.class);
		//1.2.1
		app.addInitializers(new MyApplicationContextInitializer());
		ConfigurableApplicationContext context = app.run(args);
		//通过@EnableAutoConfiguration自动管理的第三方JAR
		System.out.println(context.getBean(User.class));
		
		
		context.close();
	}

}
