package CTCI.ch16moderate;

import java.util.*;

public class Q11DivingBoard {

    public static void main(String[] args) {
        new Q11DivingBoard().run();
    }

    public void run(){
        System.out.println(divingBoards(1,2,10));
    }

    public Set<Integer> divingBoards(int shortLength, int longLength, int k){
        Set<Integer> ans = new HashSet<>();

        for (int i = 0; i <= k; i++) {
            ans.add(shortLength*(k-i)+longLength*i);
        }

        return ans;
    }

}
