package codingBlocks.arrays;

import java.util.*;

public class SunnyBuildings {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {

            int N = sc.nextInt();
            List<Integer> array = new ArrayList<Integer>();

            for (int j = 0; j < N; j++) {
                int inpNum = sc.nextInt();
                array.add(inpNum);
            }

            System.out.println(getNumberOfBuidlingsReceivingSunlight(array));
        }
    }

    public static int getNumberOfBuidlingsReceivingSunlight(List<Integer> array){
        int ans = 0;
        int maxH = array.get(0);

        for (int i = 0; i < array.size(); i++) {
            if( array.get(i) >= maxH ){
                ans++;
            }

            maxH = max(maxH, array.get(i));
        }

        return ans;
    }

    public static int max(int num1, int num2){
        if( num1 > num2 ){
            return num1;
        }

        return num2;
    }

}
