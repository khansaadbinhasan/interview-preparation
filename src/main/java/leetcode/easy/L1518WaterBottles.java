package leetcode.easy;

//9
//3
//15
//4
//1
//2
//5
//2
//2
//2
//3
//3
//100
//10
//100
//100
public class L1518WaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {

        int numDrink = numBottles;

        while( numBottles >= numExchange ){
            int bottlesGot = numBottles / numExchange;
            numDrink += bottlesGot;
            numBottles = numBottles % numExchange + bottlesGot;
        }

        return numDrink;
    }
}
