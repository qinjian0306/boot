package com.qj.springboot;

import com.qj.springboot.websocket.MyWebSocket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootApplication{

	@Bean
	@ConfigurationProperties("db2")
	public static DataSource getDataSource(){
		return new DataSource();
	}
	public static void main(String[] args) {

		System.out.println(getDataSource().toString());

		SpringApplication springApplication = new SpringApplication(SpringbootApplication.class);
		ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
		MyWebSocket.setApplicationContext(configurableApplicationContext);//解决WebSocket不能注入的问题

//		SpringApplication.run(SpringbootApplication.class, args);
	}



}
