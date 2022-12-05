package fr.univ_smb.iae.ime.mailsorter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "fr.univ_smb.iae.ime.mailsorter.controllers", "fr.univ_smb.iae.ime.mailsorter.services" }) // to scan repository files
@EntityScan("fr.univ_smb.iae.ime.mailsorter.models")
@EnableJpaRepositories("fr.univ_smb.iae.ime.mailsorter.repositories")
public class MailsorterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailsorterApplication.class, args);
		
	}

}
