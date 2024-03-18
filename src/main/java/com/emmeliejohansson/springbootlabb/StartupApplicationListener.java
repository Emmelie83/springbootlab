package com.emmeliejohansson.springbootlabb;

import jakarta.transaction.Transactional;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class StartupApplicationListener {
    private static final Logger LOG
            = Logger.getLogger(StartupApplicationListener.class.getName());
    private CatRepository catRepository;

    public StartupApplicationListener(CatRepository catRepository) {
        this.catRepository = catRepository;
    }
    @EventListener
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
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
