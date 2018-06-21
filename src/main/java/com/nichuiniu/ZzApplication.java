package com.nichuiniu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
//@MapperScan(basePackages ="com.nichuiniu.dao")//将项目中对应的mapper类的路径加进来就可以了
public class ZzApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZzApplication.class, args);
	}
}
