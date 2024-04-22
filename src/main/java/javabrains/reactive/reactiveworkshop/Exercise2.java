package javabrains.reactive.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        Flux<Integer> stream = ReactiveSources.intNumbersFlux();
        stream.subscribe(e -> System.out.println(e.intValue()));
        stream.subscribe(e -> System.out.println("Other: " + e.intValue()));

        // Print all users in the ReactiveSources.userFlux stream
//        ReactiveSources.userFlux().subscribe(user -> System.out.println(user));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
