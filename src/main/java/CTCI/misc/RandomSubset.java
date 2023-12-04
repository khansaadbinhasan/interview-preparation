package CTCI.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RandomSubset {

    public static void main(String[] args) {
        new RandomSubset().run();
    }

    public void run(){

        List<Integer> lst = new LinkedList<>();

        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);

        System.out.println(getRandomSubset(lst));

    }

    public List<Integer> getRandomSubset(List<Integer> list){

        List<Integer> subset = new ArrayList<>();

        Random random = new Random();

        for( int item: list ){
            if( random.nextBoolean() ) subset.add(item);
        }

        return subset;
    }

    public List<Integer> getRandomSubsetlambda(List<Integer> list){

        Random random = new Random();

        List<Integer> subset = list.stream().filter(
                k -> {
                    return random.nextBoolean();
                }
        ).collect(Collectors.toList());

        return subset;
    }

    Random random = new Random();

    Predicate<Object> flipCoin = o -> {
        return random.nextBoolean();
    };


    public List<Integer> getRandomSubsetPredicate(List<Integer> list){
        return list.stream().filter(flipCoin).collect(Collectors.toList());
    }

}
