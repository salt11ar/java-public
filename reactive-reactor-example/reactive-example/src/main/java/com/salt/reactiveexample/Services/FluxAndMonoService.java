package com.salt.reactiveexample.Services;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxAndMonoService {
    public Flux<String> fruitsFlux() {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana")).log();
    }

    public Mono<String> fruitMono(){    
        return Mono.just("Apple");
    }

    public Mono<List<String>> fruitsMonoFlatMap(){
        return Mono.just("Mango")
                    .flatMap(s -> Mono.just(List.of(s.split("") )))
                    .log();  
    } 


    /**
     * 
     * @return the Mono converted to Flux 
     */
    public Flux<String> fruitsMonoToFluxFlatMapMany(){
        return Mono.just("Mango")
                    .flatMapMany(s -> Flux.just(s.split("") ))
                    .log();  
    } 

    public Flux<String> fruitsFluxMap(){
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                    .map(String::toUpperCase)
                    .log();  
    }

    public Flux<String> fruitsFluxFilter(int number){
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                    .filter(s -> s.length() > number)
                    .log();  
    }
    
    public Flux<String> fruitsFluxFlatMap(){
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                    .flatMap(s -> Flux.just(s.split("") ))
                    .log();  
    }

    public Flux<String>  fruitsFluxTransform(int number){
       
        Function<Flux<String>,Flux<String>> filterData
                = data -> data.filter(s->s.length()> number);

        return Flux.fromIterable(List.of("Mango","Orange","Banana"))
                .transform(filterData)
                .defaultIfEmpty("DefaultValue")  // default value IF EMPTY RESULT
                .log();
                                                    
    }
    
    /*
     * Flux can be in diff order
     */
    public Flux<String> fruitsFluxFlatMapAsync(){
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                    .flatMap(s -> Flux.just(s.split("") ))
                    .delayElements(Duration.ofMillis(
                                    new Random().nextInt(1000)
                    ))  
                    .log();  
    }

    /*
     * in sequential order
     */
    public Flux<String> fruitsFluxConcatMap(){
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                    .concatMap(s -> Flux.just(s.split("") ))
                    .delayElements(Duration.ofMillis(
                                    new Random().nextInt(1000)
                    ))  
                    .log();  
    }

     public static void main(String[] args) {
        FluxAndMonoService fluxAndMonoService = new FluxAndMonoService();
    
        fluxAndMonoService.fruitsFlux().subscribe(s -> {
            System.out.println("s = " + s);

        });

        fluxAndMonoService.fruitsFlux().subscribe(System.out::println);

        fluxAndMonoService.fruitMono().subscribe(System.out::println);    

        fluxAndMonoService.fruitsFluxFlatMap().subscribe(System.out::println);    


    }
}
