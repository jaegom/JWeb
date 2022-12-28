package com.jweb.sbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// extends SpringBootServletInitializer // 기본 Runtime에 내장 톰캣을 쓰지 않겠다.

@SpringBootApplication
public class JWebApplication {
/*	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JWebApplication.class);
    }
*/
	public static void main(String[] args) {
		SpringApplication.run(JWebApplication.class, args);
	}
}
