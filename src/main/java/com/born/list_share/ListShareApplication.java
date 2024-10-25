package com.born.list_share;

import com.born.list_share.config.DbConfig;
import com.born.list_share.config.ApiConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({DbConfig.class, ApiConfig.class})
public class ListShareApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListShareApplication.class, args);
	}

}
