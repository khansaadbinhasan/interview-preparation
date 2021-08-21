package arrays;

import java.util.*;

public class FindCycleInArray {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        List<Integer> array = new ArrayList<Integer>();
        int N = 0;

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int inpNum = sc.nextInt();
            array.add(inpNum);
        }

        if( circularLoop(array) ){
            System.out.println(1);
        }

        else {
            System.out.println(0);
        }

    }

    private static boolean circularLoop(List<Integer> array){
        for (int i = 0; i < array.size(); i++) {

            int slow = i;
            int fast = next(array, slow);

            if( array.get(i) == 0 ){
                continue;
            }

            while(  array.get(slow)*array.get(next(array,slow)) > 0 &&
                    array.get(fast)*array.get(next(array,fast)) > 0 &&
                    array.get(fast)*array.get(next(array,next(array,fast))) > 0){

                if( slow == fast ){
                    if( slow == next(array, slow) )
                        break;

                    return true;
                }

                slow = next(array,slow);
                fast = next(array,next(array,fast));
            }

            slow = i;
            int val = array.get(slow);

            while( val * array.get(slow) > 0 ){
                int x = slow;
                slow = next(array, slow);
                array.set(x, 0);
            }
        }
        
        return false;
    }

    private static int next(List<Integer> array, int index){
        return (index + array.get(index) + array.size())%array.size();
    }

}
