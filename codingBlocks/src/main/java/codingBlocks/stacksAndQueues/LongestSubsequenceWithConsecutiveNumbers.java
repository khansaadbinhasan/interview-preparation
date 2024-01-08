package codingBlocks.stacksAndQueues;

import java.util.*;

//[100,4,200,1,3,2]
//[0,3,7,2,5,8,4,6,0,1]
//[]
//[1,3,4,1,5,6,8,9,100]
//[1,10,90,80]
//[1,100,98,76,54,31,10,19,18,171,17,16,15,11,100]
//[3,7,2,4,9,4,8,5,-1,1,0]
//[-7,-1,3,-9,-4,7,-3,2,4,9,4,-9,8,-7,5,-1,-7]

public class LongestSubsequenceWithConsecutiveNumbers {

    public static void main(String[] args) {
        new LongestSubsequenceWithConsecutiveNumbers().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(longestSubsequence(nums));
    }

    public int longestSubsequence(int[] nums){
        int lenSubSequence = 0;

        Set<Integer> numSet = new HashSet<>();

        for(int num: nums) numSet.add(num);

        Iterator itr = numSet.iterator();

        while( itr.hasNext() ){

            int num = (int) itr.next();

            itr.remove();

            int numMin1 = num-1;
            int numPlus1 = num+1;

            int currLen = 1;

            while( ( numSet.contains(numMin1) || numSet.contains(numPlus1) ) && itr.hasNext() ){
                if( numSet.contains(numMin1) ) {
                    itr.next();
                    itr.remove();

                    numMin1 = numMin1-1;

                    currLen++;
                }

                if( numSet.contains(numPlus1) && itr.hasNext() ) {
                    itr.next();
                    itr.remove();

                    numPlus1 = numPlus1+1;

                    currLen++;
                }

            }

            lenSubSequence = Math.max(lenSubSequence, currLen);
        }

        return lenSubSequence;
    }


    public int longestConsecutive(int[] nums) {
        int lenSubSequence = 0;

        Set<Integer> numSet1 = new HashSet<>();
        Set<Integer> numSet2 = new HashSet<>();


        for(int num: nums) numSet1.add(num);
        for(int num: nums) numSet2.add(num);


        for( int num: numSet1 ){

            if( numSet2.contains(num) ){
                numSet2.remove(num);

                int numMin1 = num-1;
                int numPlus1 = num+1;

                int currLen = 1;

                while( numSet1.contains(numMin1) || numSet1.contains(numPlus1) ){
                    if( numSet1.contains(numMin1) ) {
                        numMin1 = numMin1-1;
                        numSet2.remove(numMin1);
                        currLen++;
                    }

                    if( numSet1.contains(numPlus1) ) {
                        numPlus1 = numPlus1+1;
                        numSet2.remove(numPlus1);
                        currLen++;
                    }
                }

                lenSubSequence = Math.max(lenSubSequence, currLen);
            }

        }

        return lenSubSequence;

    }

}
