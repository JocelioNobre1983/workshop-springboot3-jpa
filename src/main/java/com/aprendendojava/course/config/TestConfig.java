package com.aprendendojava.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aprendendojava.course.entities.User;
import com.aprendendojava.course.repositories.UserRepository;

@Configuration//indica que se trata de uma classe espefífica de configuração
@Profile("test")//indica que a classe é espefícica para o perfil "test", igual ao que tem no profile
public class TestConfig implements CommandLineRunner{//Interace: executa tarefas de inicialização ou configuração antes do processamento de solicitações. 
	
	@Autowired//ativar a autodenpencia
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
}
