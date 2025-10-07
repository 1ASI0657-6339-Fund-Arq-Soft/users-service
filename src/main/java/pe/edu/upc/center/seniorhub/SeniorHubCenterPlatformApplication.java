package pe.edu.upc.center.seniorhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SeniorHubCenterPlatformApplication { 
	public static void main(String[] args) {
		SpringApplication.run(SeniorHubCenterPlatformApplication.class, args);
	}

}
