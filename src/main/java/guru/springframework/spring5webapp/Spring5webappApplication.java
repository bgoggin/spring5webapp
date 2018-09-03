package guru.springframework.spring5webapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring5webappApplication {

	public static void main(String[] args) {
		Logger log = LogManager.getRootLogger();
		log.info("starting up");
		SpringApplication.run(Spring5webappApplication.class, args);
	}
}
