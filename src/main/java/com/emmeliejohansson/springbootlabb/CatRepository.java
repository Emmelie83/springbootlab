package com.emmeliejohansson.springbootlabb;

import org.springframework.data.repository.ListCrudRepository;

public interface CatRepository extends ListCrudRepository<Cat, Long> {
}
