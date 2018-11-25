package com.macross;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.macross.dao")
public class MacrossApplication {

	public static void main(String[] args) {
		SpringApplication.run(MacrossApplication.class, args);
	}
}
