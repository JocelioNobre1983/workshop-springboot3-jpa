package com.aprendendojava.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aprendendojava.course.entities.Category;
import com.aprendendojava.course.entities.Order;
import com.aprendendojava.course.entities.Product;
import com.aprendendojava.course.entities.User;
import com.aprendendojava.course.entities.enuns.OrderStatus;
import com.aprendendojava.course.repositories.CategoryRepository;
import com.aprendendojava.course.repositories.OrderRepository;
import com.aprendendojava.course.repositories.ProductRepository;
import com.aprendendojava.course.repositories.UserRepository;

@Configuration//indica que se trata de uma classe espefífica de configuração
@Profile("test")//indica que a classe é espefícica para o perfil "test", igual ao que tem no profile
public class TestConfig implements CommandLineRunner{//Interace: executa tarefas de inicialização ou configuração antes do processamento de solicitações. 
	
	@Autowired//ativar a autodenpencia
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2024-02-24T10:00:07Z"), OrderStatus.PAID, u1); 
		Order o2 = new Order(null, Instant.parse("2024-01-30T03:42:10Z"), OrderStatus.WAITING_PAIMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2024-02-15T15:21:22Z"), OrderStatus.WAITING_PAIMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		
	}
}
