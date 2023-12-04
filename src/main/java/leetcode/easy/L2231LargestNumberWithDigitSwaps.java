package leetcode.easy;


import java.util.*;

//1234
//65875
//1
//2
//10000000
//37549374984379
public class L2231LargestNumberWithDigitSwaps {

    public static void main(String[] args) {
        new L2231LargestNumberWithDigitSwaps().run();
    }

    public void run(){
        System.out.println(largestInteger(1234));
    }

    public int largestInteger(int num) {

        List<Integer> oddIntegers = getOddIntegers(num);
        List<Integer> evenIntegers = getEvenIntegers(num);

        if( (oddIntegers.size() + evenIntegers.size()) % 2 == 0 ){
            List<Integer> temp = oddIntegers;
            oddIntegers = evenIntegers;
            evenIntegers = temp;
        }

        oddIntegers.sort(Collections.reverseOrder());
        evenIntegers.sort(Collections.reverseOrder());

        int size = oddIntegers.size();
        int newNum = 0;

        for( int i = 0; i < size; i++ ){
            newNum = newNum*10 + oddIntegers.get(i);

            if( i < evenIntegers.size() ){
                newNum = newNum*10 + evenIntegers.get(i);
            }
        }

        if( evenIntegers.size() > oddIntegers.size() ){
            newNum = newNum*10 + evenIntegers.get(oddIntegers.size()-1);
        }

        return newNum;
    }

    List<Integer> getOddIntegers(int num){
        List<Integer> oddIntegers = new LinkedList<>();

        while( num != 0 ){
            oddIntegers.add(num % 10);
            num = num / 100;
        }

        return oddIntegers;
    }

    List<Integer> getEvenIntegers(int num){
        List<Integer> evenIntegers = new LinkedList<>();

        num = num / 10;

        while( num != 0 ){
            evenIntegers.add(num % 10);
            num = num / 100;
        }

        return evenIntegers;
    }
}
