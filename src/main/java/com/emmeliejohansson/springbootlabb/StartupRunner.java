package com.emmeliejohansson.springbootlabb;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

//@Component
public class StartupRunner implements ApplicationRunner {
    private static final Logger LOG
            = Logger.getLogger(StartupRunner.class.getName());
    private CatRepository catRepository;

    public StartupRunner(CatRepository catRepository) {
        this.catRepository = catRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOG.info("Checking for Misse");
        var result = catRepository.findByName("Misse");
        if (result.isEmpty()) {
            var cat = new Cat();
            cat.setName("Misse");
            cat.setAge(2);
            catRepository.save(cat);
        }
    }
}
