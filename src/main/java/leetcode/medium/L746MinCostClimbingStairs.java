package leetcode.medium;

//[10,15,20]
//[1,100,1,1,1,100,1,1,100,1]
//[0,0,0]
//[1,2,3,4,5,6]
//[8,7,6,5,4,3,2,1]
//[1,1,1,1,1,1,1,1,1,1]
//[100,11,10,8,7,1,3,100,98,77,43,21,100]
//[1,100]
public class L746MinCostClimbingStairs {

    public static void main(String[] args) {
        new L746MinCostClimbingStairs().run();
    }

    public void run(){
        System.out.println(minCostClimbingStairs(new int[]{8,7,6,5,4,3,2,1}));
    }

    public int minCostClimbingStairs(int[] cost) {

        if( cost.length < 2 ) return 0;

        int[] steps = new int[cost.length+1];

        for( int i = 2; i <= cost.length; i++ ){
            if( steps[i-1]+cost[i-1] < steps[i-2]+cost[i-2] ){
                steps[i] = steps[i-1]+cost[i-1];
            }

            else{
                steps[i] = steps[i-2]+cost[i-2];
            }
        }

        return steps[steps.length-1];
    }

}
