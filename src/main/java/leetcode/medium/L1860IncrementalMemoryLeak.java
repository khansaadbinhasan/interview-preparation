package leetcode.medium;

//2
//2
//8
//11
//1
//1
//1
//100
//1000
//100
//1000
//999
//2147483647
//2147483647
//2147483647
//2147483646
public class L1860IncrementalMemoryLeak {

    public int[] memLeak(int memory1, int memory2) {

        int time = 1;

        while( true ){
            if( memory2 > memory1 ){
                if( time > memory2 ) {
                    break;
                }
                memory2 -= time;
            }

            else{
                if( time > memory1 ) {
                    break;
                }
                memory1 -= time;
            }

            time++;
        }

        return new int[]{time, memory1, memory2};
    }


}
