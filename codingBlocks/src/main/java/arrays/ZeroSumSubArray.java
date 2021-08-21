package arrays;


import java.util.*;

//You are given an array arr of size N. You need to print the total count of sub-arrays having their sum equal to 0
//6
//9
//4 5 -3 1 -3 2 -6 4 11
//9
//1 2 3 -1 -2 0 1 1 -3
//8
//-1 1 2 -1 -3 1 0 1
//1
//1
//2
//1 -1
//3
//1 -1 0
public class ZeroSumSubArray {

    public static void main(String[] args) {
        new ZeroSumSubArray().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] nums = new int[N];

            for (int j = 0; j < N; j++) {
                nums[j] = sc.nextInt();
            }

            ans.add(getCountZeroSumSubAr(nums));
        }

        for( int a: ans ){
            System.out.println(a);
        }
    }

    public int getCountZeroSumSubAr(int[] nums){
        int sum = 0;
        int count = 0;

        Map<Integer, Integer> sumCount = new HashMap<>();

        sumCount.put(sum, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if( sumCount.containsKey(sum) ) sumCount.put(sum, sumCount.get(sum)+1);
            else sumCount.put(sum, 1);
        }

        for( Map.Entry<Integer, Integer> entry: sumCount.entrySet() ){
            int n = entry.getValue();
            count += n*(n-1)/2;
        }
        
        return count;
    }
}
