package interviews.google.prepQuestions;

import java.util.*;

//1,2,3,9
//10
//1,2,3,9
//8
//1,1,1,1
//3
//1
//1
//1,1
//2
//1,1,1
//1
//1,2,3,4,5,6,7,8,9,10
//7
public class Sorted2Sum {

    public static void main(String[] args) {
        new Sorted2Sum().run();
    }

    public void run(){
        int[] arr = new int[]{1,2,3,9};
        int target = 10;
        System.out.println("Expected (1,9), Actual: " + getPair(arr, target));

        arr = new int[]{1,2,3,9};
        target = 8;
        System.out.println("Expected (null), Actual: " + getPair(arr, target));

        arr = new int[]{1,1,1,1};
        target = 3;
        System.out.println("Expected (null), Actual: " + getPair(arr, target));

        arr = new int[]{1};
        target = 1;
        System.out.println("Expected (null), Actual: " + getPair(arr, target));

        arr = new int[]{1,1};
        target = 2;
        System.out.println("Expected (1,1), Actual: " + getPair(arr, target));

        arr = new int[]{1,1,1};
        target = 1;
        System.out.println("Expected (null), Actual: " + getPair(arr, target));

        arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        target = 7;
        System.out.println("Expected (1,6), Actual: " + getPair(arr, target));

        arr = new int[]{4,4};
        target = 8;
        System.out.println("Expected (4,4), Actual: " + getPair(arr, target));

        arr = new int[]{3,4};
        target = 8;
        System.out.println("Expected (null), Actual: " + getPair(arr, target));



        arr = new int[]{1,2,3,9};
        target = 10;
        System.out.println("Expected (1,9), Actual: " + getPairWithHashSet(arr, target));

        arr = new int[]{1,2,3,9};
        target = 8;
        System.out.println("Expected (null), Actual: " + getPairWithHashSet(arr, target));

        arr = new int[]{1,1,1,1};
        target = 3;
        System.out.println("Expected (null), Actual: " + getPairWithHashSet(arr, target));

        arr = new int[]{1};
        target = 1;
        System.out.println("Expected (null), Actual: " + getPairWithHashSet(arr, target));

        arr = new int[]{1,1};
        target = 2;
        System.out.println("Expected (1,1), Actual: " + getPairWithHashSet(arr, target));

        arr = new int[]{1,1,1};
        target = 1;
        System.out.println("Expected (null), Actual: " + getPairWithHashSet(arr, target));

        arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        target = 7;
        System.out.println("Expected (1,6), Actual: " + getPairWithHashSet(arr, target));

        arr = new int[]{4,4};
        target = 8;
        System.out.println("Expected (4,4), Actual: " + getPairWithHashSet(arr, target));

        arr = new int[]{3,4};
        target = 8;
        System.out.println("Expected (null), Actual: " + getPairWithHashSet(arr, target));


        arr = new int[]{4,4};
        target = 8;
        System.out.println("Expected true, Actual: " + hasPairWithSum(arr, target));

        arr = new int[]{3,4};
        target = 8;
        System.out.println("Expected false, Actual: " + hasPairWithSum(arr, target));

    }

    //1,1,1,1
    //3
    //1
    //1
    //1,1
    //2
    //1,1,1
    //1
    //1,2,3,9
    //10
    //1,2,3,9
    //8
    private String getPair(int[] arr, int target) {
        int p1 = 0;
        int p2 = arr.length-1;

        String res = "";

        while( p1 < arr.length && p2 > 0 && p1 < p2 ){
            if( arr[p1] + arr[p2] > target ) p2--;
            else if( arr[p1] + arr[p2] < target ) p1++;
            else {
                res += arr[p1] + "," + arr[p2] + "\n";
                p1++;
                p2--;
            }
        }

        return res.isEmpty() ? null: res;
    }

    private String getPairWithHashSet(int[] arr, int target) {
        Set<Integer> nums = new HashSet<>();
        int sum = 0;
        String res = "";

        for (int i = 0; i < arr.length; i++) {
            nums.add(arr[i]);

            if( target % 2 == 0 && arr[i] == target / 2 ){
                sum += arr[i];
                res += arr[i] + ",";

                if( sum == target )
                    return res;
            }
        }

        if( target % 2 == 0 ){
            nums.remove(target/2);
        }

        for (int i = 0; i < arr.length; i++) {
            if( nums.contains(target - arr[i]) ) return arr[i] + "," + (target-arr[i]);
        }


        return null;
    }

    public boolean hasPairWithSum(int[] arr, int sum){
        Set<Integer> set = new HashSet<>();

        for(int value: arr){
            if( set.contains(value) ) return true;
            set.add(sum-value);
        }

        return false;
    }

    static int[] getIndicesOfItemWeights(int[] arr, int limit) {

        Map<Integer, Integer> map = new HashMap<>();

        for( int i = 0; i < arr.length; i++ ){
            int w = arr[i];
            Integer complementIndex = map.get(limit-w);

            if( complementIndex != null ){
                return new int[]{i, complementIndex};
            }

            else{
                map.put(w, i);
            }
        }

        return new int[]{};
    }

}
