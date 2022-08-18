package com.salt.reactiveexample.Services;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class FluxAndMonoServiceTest {
    
    FluxAndMonoService fluxaAndMonoService = new FluxAndMonoService();
    
    /**
     * 
     */
    @Test
    void testFruitMono() {
        var fruitsFlux = fluxaAndMonoService.fruitsFlux();
        StepVerifier.create( fruitsFlux)
            .expectNext("Mango", "Orange", "Banana") 
            .verifyComplete();
        
    }

    @Test
    void testFruitsFlux() {

    }
}
