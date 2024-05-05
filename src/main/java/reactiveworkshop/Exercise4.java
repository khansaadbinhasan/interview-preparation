package reactiveworkshop;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Exercise4 {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        Mono<Integer> integerMono = ReactiveSources.intNumberMono();


        integerMono.subscribe(number -> System.out.println(number));

        integerMono.subscribe(
                number -> System.out.println(number),
                err -> System.out.println(err.getCause()),
                () -> System.out.println("Complete")
        );

//        // Get the value from the Mono into an integer variable
//        Integer num = integerMono.toFuture().get();
//        System.out.println("future " + num);
//        num = integerMono.block();
//        System.out.println("given " + num);
//        num = integerMono.blockOptional().get();
//        System.out.println("optional " + num);
//
//        User foo = ReactiveSources.userMono().block();

//        integerMono
//                .subscribe(
//                        number -> System.out.println(number)
////                        ,
////                        err -> System.out.println(err.getCause()),
////                        () -> System.out.println("Complete")
//                );

        System.out.println("Press a key to end");
        System.in.read();
    }

}
