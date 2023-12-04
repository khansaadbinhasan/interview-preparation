package leetcode.easy;

//[0,1,2,3,4]
//2
//[5,1,4,2,2]
//6
//[1]
//0
//[1]
//1
//[1]
//2
public class L2790NumEmployeesMetTarget {

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {

        int num = 0;

        for( int i = 0; i < hours.length; i++ ){
            if( hours[i] >= target ) num++;
        }

        return num;
    }
}
