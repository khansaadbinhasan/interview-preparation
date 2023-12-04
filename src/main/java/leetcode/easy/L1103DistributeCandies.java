package leetcode.easy;

import java.util.LinkedList;

//7
//4
//10
//3
//20
//3
//3
//20
//100
//1
//1
//100
//1000000000
//1000
//1
//1
public class L1103DistributeCandies {

    public int[] distributeCandies(int candies, int num_people) {

        int n = num_people;

        int[] peoples = new int[num_people];
        int lastCandies = 0;

        while( candies > 0 ){
            int candiesToGive = lastCandies+1;

            if( candiesToGive > candies ) {
                peoples[0] += candies;
                return peoples;
            }

            candies -= candiesToGive;
            peoples[0] += candiesToGive;
            lastCandies = candiesToGive;

            for( int i = 1; i < peoples.length; i++ ){
                candiesToGive = lastCandies + 1;
                if( candiesToGive > candies ) {
                    peoples[i] += candies;
                    return peoples;
                }
                peoples[i] += candiesToGive;
                candies -= candiesToGive;
                lastCandies = candiesToGive;
            }
        }

        return peoples;
    }
}
