package com.emmeliejohansson.springbootlabb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class SpringBootLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLabApplication.class, args);
	}

}

@RestController
class RestEndpoints {

	public RestEndpoints(CatRepository repository) {
		this.repository = repository;
	}

	CatRepository repository;
	@GetMapping("/cats")
	List<Cat> cats() {
		var cat = new Cat();
		cat.setName("Misse");
		repository.save(cat);
		return repository.findAll();
	}
}
