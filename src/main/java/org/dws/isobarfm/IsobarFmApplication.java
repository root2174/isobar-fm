package org.dws.isobarfm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class IsobarFmApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsobarFmApplication.class, args);
	}

}
