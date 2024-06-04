package com.jaeil.calendar.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface SimpleEntityRepository extends JpaRepository<SimpleEntity, Long> {
}
