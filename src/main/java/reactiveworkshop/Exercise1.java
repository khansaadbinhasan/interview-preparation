package reactiveworkshop;

import java.util.Optional;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(n -> System.out.print(n + ","));
        System.out.println();

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(n -> n < 5).forEach(n -> System.out.print(n + ","));
        System.out.println();

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(n -> n > 5).skip(1).limit(2).forEach(n -> System.out.print(n + ","));
        System.out.println();

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        Optional<Integer> first = StreamSources.intNumbersStream().filter(n -> n > 5).findFirst();
        if( first.isPresent() ) System.out.println(first.get());
        else System.out.println(-1);

        // Print first names of all users in userStream
        StreamSources.userStream().forEach(user -> System.out.print(user.getFirstName() + ","));
        System.out.println();
        StreamSources.userStream().map(User::getFirstName).forEach(name -> System.out.print(name + ","));
        System.out.println();

        // Print first names in userStream for users that have IDs from number stream
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId()==id))
                .map(user -> user.getFirstName())
                .forEach(name -> System.out.print(name + ","));
        System.out.println();

        StreamSources.userStream()
                .filter( u -> StreamSources.intNumbersStream().anyMatch(i -> i == u.getId()))
                .forEach(user -> System.out.print(user.getFirstName() + " "));
        System.out.println();

    }

}
