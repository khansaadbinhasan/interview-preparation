package codingBlocks.hashing;

import java.util.*;


//[20,1,15,3,10,5,8]
//[1,1,1,1,1,1]


public class LongestArithmeticSubsequence {

    public static void main(String[] args) {
        new LongestArithmeticSubsequence().run();
    }

//    public void run(){
//        Scanner sc = new Scanner(System.in);
//
//        String inpStr = sc.nextLine().trim();
//
//        String[] inpArr = inpStr.substring(1,inpStr.length()-1).split(",");
//
//        int[] nums = new int[inpArr.length];
//
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = Integer.parseInt(inpArr[i]);
//        }
//
//        System.out.println(longestArithSeqLength(nums));
//    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(longestArithSeqLength(nums));
    }

    public int longestArithSeqLength(int[] nums) {

        int maxLenAP = 2;
        int currLen = 2;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> lst;

            if( !map.containsKey(nums[i]) ) lst = new LinkedList<>();
            else lst = map.get(nums[i]);

            lst.add(i);
            map.put(nums[i], lst);
        }

        for( int key: map.keySet() ){
            if( map.get(key).size() > maxLenAP ) maxLenAP = map.get(key).size();
        }

        for (int i = 0; i < nums.length-1; i++) {
            int j = i + 1;

            int diff = nums[j] - nums[i];
            int currInd = 0;

            while( j < nums.length ){

                int nextNum = nums[j]+diff;

                if( map.containsKey(nextNum) && map.get(nextNum).get(currInd) > j ){
                    currLen++;
                    j = map.get(nextNum).get(currInd);

                    if( currLen > maxLenAP ) maxLenAP = currLen;
                }

                else{
                    currLen = 2;
                    j++;
                    if( j < nums.length ) diff = nums[j] - nums[i];
                }
            }
        }

        return maxLenAP;
    }
}