package com.emmeliejohansson.springbootlabb;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CatRepository extends ListCrudRepository<Cat, Long> {
    List<Cat> findByName(String name);
}
