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
        var fruitsMono = fluxaAndMonoService.fruitMono();
        StepVerifier.create( fruitsMono)
            .expectNext("Apple") 
            .verifyComplete();
        
    }

    @Test
    void testFruitFluxMap() {
        var fruitsFluxMap = fluxaAndMonoService.fruitsFluxMap();
        StepVerifier.create(fruitsFluxMap)
                    .expectNext("MANGO","ORANGE","BANANA")
                    .verifyComplete();   

    }

    @Test
    void testFruitsFluxFilter() {

        var fruitsFluxMap = fluxaAndMonoService.fruitsFluxFilter(5);
        StepVerifier.create(fruitsFluxMap)
                    .expectNext("Orange", "Banana")
                    .verifyComplete();   

    }

    @Test
    void testFruitsFluxFlatMap() {
        var fruitsFluxFlatMap = fluxaAndMonoService.fruitsFluxFlatMap();
        StepVerifier.create(fruitsFluxFlatMap)
                    .expectNextCount(17)
                    .verifyComplete();   
    }

    @Test
    void testFruitsFluxFlatMapAsync() {
        var fruitsFluxFlatMap = fluxaAndMonoService.fruitsFluxFlatMapAsync();
        StepVerifier.create(fruitsFluxFlatMap)
                    .expectNextCount(17)
                    .verifyComplete();   
    }

    @Test
    void testFruitsFluxConcatMap() {
        var fruitsFlux = fluxaAndMonoService.fruitsFluxConcatMap();
        StepVerifier.create(fruitsFlux)
                    .expectNextCount(17)
                    .verifyComplete();   
    }

    @Test
    void testFruitsMonoToFluxFlatMapMany() {
        var fruitsFlux = fluxaAndMonoService.fruitsMonoToFluxFlatMapMany();
        StepVerifier.create(fruitsFlux)
                    .expectNextCount(5)
                    .verifyComplete();   
    }

    @Test
    void testFruitsFluxTransform() {
        var fruitsFluxMap = fluxaAndMonoService.fruitsFluxTransform(5);
        StepVerifier.create(fruitsFluxMap)
                    .expectNext("Orange", "Banana")
                    .verifyComplete();   

    }
}
