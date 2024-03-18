package com.emmeliejohansson.springbootlabb;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class SpringBootLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLabApplication.class, args);
    }

    @Bean
    ApplicationRunner databaseInit(CatRepository catRepository) {
        return args -> {
            var result = catRepository.findByName("Misse");
            if (result.isEmpty()) {
                var cat = new Cat();
                cat.setName("Misse");
                cat.setAge(2);
                catRepository.save(cat);
            }
        };
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
