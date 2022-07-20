package com.example.demo;

import java.util.Date;

import com.example.demo.configuration.AppUser;
//import com.example.demo.configuration.LoggedInUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo")).build();
	}

//	@GetMapping("/secured")
//	public Object secured(@LoggedInUser AppUser appUser){
//		return appUser.getUser();
//	}
//
//	@GetMapping("/secured-admin")
//	@PreAuthorize("hasRole('ROLE_admin')")
//	public String securedAdmin(){
//		return "Only admin can see this";
//	}
//
//	@GetMapping("/public")
//	public String pub(){
//
//		return "This is public endpoint";
//	}
//
//	@GetMapping("/what-is-the-time")
//	String time(){
//		return new Date().toString();
//	}
}
