package br.edu.infnet.alexandre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlexandreApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlexandreApplication.class,args);
	}

}
