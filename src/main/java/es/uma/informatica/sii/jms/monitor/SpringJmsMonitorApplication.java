package es.uma.informatica.sii.jms.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringJmsMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJmsMonitorApplication.class, args);
	}

}
