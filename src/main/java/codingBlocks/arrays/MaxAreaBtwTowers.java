package codingBlocks.arrays;

import java.util.*;

public class MaxAreaBtwTowers {

    public static int max(int num1, int num2){
        if( num1 > num2 )
            return num1;

        return num2;
    }

    public static int min(int num1, int num2){
        if( num1 < num2 )
            return num1;

        return num2;
    }

    public static int getArea(List<Integer> towerLengths, int left, int right){

        int length = right - left;
        int height = min(towerLengths.get(left), towerLengths.get(right));

        return length * height;

    }

    public static int getMaxArea(List<Integer> towerLengths){

        int left = 0;
        int right = towerLengths.size()-1;

        int area = 0;

        while (right > left){
            area = max(area, getArea(towerLengths, left, right));

            if( towerLengths.get(left) > towerLengths.get(right) ) right--;
            else left++;
        }

        return area;

    }

    public static void run(){
        int N = 0;
        List<Integer> towerLengths = new ArrayList<Integer>();

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int inpTowerLength = sc.nextInt();
            towerLengths.add(inpTowerLength);
        }

        System.out.println(getMaxArea(towerLengths));
    }

    public static void main(String[] args) {
        run();
    }
}
