package leetcode.medium;

//[2,2,3,3]
//5
//[1,1,1,4,2,3]
//4
//[7,7,7,7,7,7,7]
//8
public class L2079WateringPlants {

    public static void main(String[] args) {
        new L2079WateringPlants().run();
    }

    public void run(){
        System.out.println(wateringPlants(new int[]{2,2,3,3}, 5));
    }

    public int wateringPlants(int[] plants, int capacity) {

        int numSteps = 0;
        int tempCap = capacity;

        for( int i = 0; i < plants.length; i++ ){

            if( tempCap < plants[i] ){
                numSteps += 2*i;
                tempCap = capacity;
            }

            tempCap -= plants[i];
            numSteps++;
        }

        return numSteps;
    }

}
