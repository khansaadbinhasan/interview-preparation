package hashing;

import java.util.*;

public class DuplicateValues1 {

    public static void main(String[] args) {
        new DuplicateValues1().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

//        System.out.println(containsDuplicate(nums));
        System.out.println(containsNearbyDuplicate(nums, sc.nextInt()));
    }

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for( int i = 0; i < nums.length; i++ ){
            int currLen = set.size();
            set.add(nums[i]);

            if( currLen == set.size() ) return true;
        }

        return false;

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for( int i = 0; i < nums.length; i++ ){
            if( !map.isEmpty() && map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k )
                return true;

            map.put( nums[i], i );
        }

        return false;
    }
}
