package de.owemo.server.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {

    private final CounterService counterService;

    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping(path = "/counter/{name}")
    public CounterEntity getCounter(@PathVariable String name) {
        return counterService.incrementAndGet(name);
    }
}
