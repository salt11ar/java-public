package com.salt.reactiveexample.Services;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxAndMonoService {
    public Flux<String> fruitsFlux() {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana")).log();
    }

    public Mono<String> fruitMono(){    
        return Mono.just("Apple");
    }

     public static void main(String[] args) {
        FluxAndMonoService fluxAndMonoService = new FluxAndMonoService();
    
        fluxAndMonoService.fruitsFlux().subscribe(s -> {
            System.out.println("s = " + s);

        });

        fluxAndMonoService.fruitsFlux().subscribe(System.out::println);

        fluxAndMonoService.fruitMono().subscribe(System.out::println);    

    }
}
