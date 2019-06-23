package de.owemo.server.counter;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CounterService {

    // repositories
    private final CounterRepository counterRepository;

    public CounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    public CounterEntity incrementAndGet(String name) {

        Optional<CounterEntity> ce = counterRepository.findByName(name);

        if(ce.isPresent()) {
            CounterEntity counterEntity = ce.get();
            int value = counterEntity.getValue();

            counterEntity.setValue(value+1);
            this.counterRepository.save(counterEntity);
            return counterEntity;
        } else {
            CounterEntity counterEntity = CounterEntity.builder().name(name).value(1).build();
            this.counterRepository.save(counterEntity);
            return counterEntity;
        }
    }
}
