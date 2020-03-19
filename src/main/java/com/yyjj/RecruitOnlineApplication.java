package com.yyjj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages= {"com.yyjj.db.dao"})
public class RecruitOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruitOnlineApplication.class, args);
	}

}
