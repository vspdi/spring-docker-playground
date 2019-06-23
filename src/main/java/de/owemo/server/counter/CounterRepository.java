package de.owemo.server.counter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CounterRepository extends JpaRepository<CounterEntity, Long> {
    Optional<CounterEntity> findByName(String name);
}
