package com.emmeliejohansson.springbootlabb;

import org.springframework.stereotype.Component;

@Component
public class DatabaseInit {
    public DatabaseInit(CatRepository repository) {
        var cat = new Cat();
        cat.setName("Pelle");
        cat.setAge(3);
        repository.save(cat);
    }
}
