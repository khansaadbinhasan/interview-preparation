package leetcode.easy;

//14
//8
//123
//0
//1
//12

public class L1342ReduceToZero {

    //     public int numberOfSteps(int num) {

//         int steps = 0;

//         while( num > 0 ){

//             if( num % 2 == 0 ) num = num / 2;
//             else if( num % 2 != 0 ) num--;

//             steps++;
//         }

//         return steps;
//     }

    public int numberOfSteps(int num) {

        if( num == 0 ) return 0;

        int steps = 0;
        int finalBitPos = 0;

        while( num > 0 ){

            if( (num & 1) == 1 ) steps++;

            num = num >> 1;
            finalBitPos++;
        }

        return steps + finalBitPos - 1;
    }

}
