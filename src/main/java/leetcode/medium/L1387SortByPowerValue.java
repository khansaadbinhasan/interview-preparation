package leetcode.medium;

import java.util.*;

//12
//15
//2
//7
//11
//4
//1
//1000
//777
public class L1387SortByPowerValue {

    class Power implements Comparable<Power>{
        public int val;
        public int power;

        public Power(){

        }

        public Power(int val, int power){
            this.val = val;
            this.power = power;
        }

        public int compareTo(Power power){
            if( this.power > power.power ) return 1;
            if( this.power < power.power ) return -1;

            if( this.val > power.val ) return 1;
            if( this.val < power.val ) return -1;

            return 0;
        }
    }

    public int getKth(int lo, int hi, int k) {
        int[] kArr = new int[hi-lo+1];
        Power[] power = new Power[hi-lo+1];

        for( int i = 0; i < power.length; i++ ){
            power[i] = new Power();
        }

        for( int i = lo; i <= hi; i++ ){
            int pow = getPower(i);

            power[i-lo].power = pow;
            power[i-lo].val = i;
        }

        Arrays.sort(power);

        return power[k-1].val;
    }

    public int getPower(int val){
        if( val == 1 ) {
            return 0;
        }

        if( val % 2 == 0 ){
            return getPower(val/2) + 1;
        }

        else{
            return getPower(3*val+1) + 1;
        }
    }


}
