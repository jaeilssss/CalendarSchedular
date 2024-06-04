package com.jaeil.calendar.api;

import com.jaeil.calendar.core.SimpleEntity;
import com.jaeil.calendar.core.SimpleEntityRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EntityScan("com.jaeil.calendar.core")
@EnableJpaRepositories("com.jaeil.calendar.core")
@RestController
@SpringBootApplication
public class ApiApplication {

    private final SimpleEntityRepository simpleEntityRepository;

    public ApiApplication(SimpleEntityRepository simpleEntityRepository) {
        this.simpleEntityRepository = simpleEntityRepository;
    }

    @GetMapping
    public List<SimpleEntity> findAll() {
        return simpleEntityRepository.findAll();
    }

    @PostMapping("/save")
    public SimpleEntity saveOne() {
        final SimpleEntity simpleEntity = new SimpleEntity();

        simpleEntity.setName("hello");
        return simpleEntityRepository.save(simpleEntity);
    }

    public static void main(String [] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
